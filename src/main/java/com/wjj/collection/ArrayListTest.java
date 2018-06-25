package com.wjj.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 作者：wangjj
 * @version 版本：
 * @createTime 创建时间：2018-06-08 19:10
 * @discription 类说明：ArrayList学习
 */
public class ArrayListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String a = (String) iterator.next();
            if (a.equals("c")) {
                list.remove(a);
            } else {
                System.out.println(a);
            }
        }
    }
}
