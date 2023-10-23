package com.yunhui.design.pattern.decorator.exp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * Created on 2021-05-12
 */
public interface Decorator extends Component {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(5);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(2, 1);

        System.out.println(list.size());

    }

}
