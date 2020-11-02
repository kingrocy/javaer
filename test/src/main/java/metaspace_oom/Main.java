package metaspace_oom;

import org.springframework.cglib.beans.BeanCopier;

/**
 * @Date : 2020/10/22 1:42 下午
 * @Author : dushaoyun
 */
public class Main {


    public static void main(String[] args) throws InterruptedException {

        Main main=new Main();

        while (true){

          new Thread(()->{
              main.get();

              try {
                  Thread.sleep(100);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }).start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    private PortraitLabelInfoVO get(){
        PortraitLabelInfo portraitGroupInfo = new PortraitLabelInfo();
        portraitGroupInfo.setId(1);
        portraitGroupInfo.setLabelBiz(1);
        portraitGroupInfo.setLabelDomain(1);
        portraitGroupInfo.setLabelName("222");
        portraitGroupInfo.setLabelType(2);
        portraitGroupInfo.setLabelTypeSecond(22);
        portraitGroupInfo.setLabelTypeFirst(444);

        BeanCopier beanCopier = BeanCopier.create(PortraitLabelInfo.class, PortraitLabelInfoVO.class, false);
        PortraitLabelInfoVO vo = new PortraitLabelInfoVO();
        beanCopier.copy(portraitGroupInfo, vo, null);

        return vo;
    }
}
