package base;

/**
 * @Date : 2021/2/4 2:01 下午
 * @Author : dushaoyun
 */
public interface IService {

    int add(int a,int b);

    /**
     * @Date : 2021/2/4 2:12 下午
     * @Author : dushaoyun
     */
    class ServiceImpl implements IService {


        @Override
        public int add(int a, int b) {
            return a+b;
        }
    }
}
