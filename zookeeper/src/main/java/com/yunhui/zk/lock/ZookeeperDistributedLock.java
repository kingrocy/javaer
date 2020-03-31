package com.yunhui.zk.lock;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.log4j.Logger;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author: alex
 * @Date: 2019/4/8
 * @Description: 分布式锁实现
 */
public class ZookeeperDistributedLock implements Lock {

    protected static Logger logger = Logger.getLogger(ZookeeperDistributedLock.class);

    /**
     * zookeeper服务地址
     */
    private String hosts = "118.25.172.253:2181";

    /**
     * zk客户端
     */
    private ZkClient client;

    /**
     * 当前节点
     */
    private ThreadLocal<String> currentPath = new ThreadLocal<>();

    /**
     * 前一个节点
     */
    private ThreadLocal<String> beforePath = new ThreadLocal<>();

    /**
     * 构造方法
     */
    public ZookeeperDistributedLock() {
        //获得客端
        this.client = new ZkClient(hosts);
        //设置序列化类
        this.client.setZkSerializer(new MyZkSerializer());
        //判断根节点是否存在，不存在则创建
        if (!this.client.exists(Constant.LOCKPATH)) {
            try {
                this.client.createPersistent(Constant.LOCKPATH);
            } catch (Exception e) {
                logger.error("ZkClient create root node failed...");
                logger.error(e);
            }
        }
    }

    /**
     * 加锁方法
     */
    @Override
    public void lock() {
        //如果没有获得到锁，那么就等待，一直到获得到锁为止
        if (!tryLock()) {
            // 没有获得锁，阻塞自己
            waitForLock();
            // 再次尝试加锁
            lock();
        }
    }

    /**
     * 释放锁
     */
    @Override
    public void unlock() {
        this.client.delete(this.currentPath.get());
    }

    /**
     * 尝试获取锁
     * @return true拿到锁 false没拿到锁
     */
    @Override
    public boolean tryLock() {
        //当前节点为空，说明还没有线程来创建节点
        if(this.currentPath.get() == null) {
            this.currentPath.set(this.client.createEphemeralSequential(Constant.LOCKPATH + Constant.SEPARATOR,"data"));
        }
        //获取所有子节点
        List<String> children = this.client.getChildren(Constant.LOCKPATH);
        //排序
        Collections.sort(children);
        //判断当前节点是否是最小的节点
        if(this.currentPath.get().equals(Constant.LOCKPATH + Constant.SEPARATOR + children.get(0))) {
            return true;
        } else {
            //获取当前节点的位置
            int curIndex = children.indexOf(this.currentPath.get().substring(Constant.LOCKPATH.length() + 1));
            //设置前一个节点
            beforePath.set(Constant.LOCKPATH + Constant.SEPARATOR + children.get(curIndex - 1));
        }
        return false;
    }

    /**
     * 等待锁
     */
    private void waitForLock() {
        //声明一个计数器
        CountDownLatch cdl = new CountDownLatch(1);
        IZkDataListener listener = new IZkDataListener() {
            @Override
            public void handleDataChange(String arg0, Object arg1) throws Exception {
            }
            @Override
            public void handleDataDeleted(String arg0) throws Exception {
                logger.info("Ephemeral node has been deleted....");
                //计数器减一
                cdl.countDown();
            }
        };
        //完成watcher注册
        this.client.subscribeDataChanges(this.beforePath.get(), listener);
        //阻塞自己
        if (this.client.exists(this.beforePath.get())) {
            try {
                cdl.await();
            } catch (InterruptedException e) {
                logger.error("CountDownLatch thread has been interrupted...");
                logger.error(e);
            }
        }
        //取消注册
        this.client.unsubscribeDataChanges(this.beforePath.get(), listener);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    public String getHosts() {
        return hosts;
    }

    public void setHosts(String hosts) {
        this.hosts = hosts;
    }

}