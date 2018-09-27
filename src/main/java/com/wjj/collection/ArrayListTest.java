package com.wjj.collection;

import org.junit.Test;

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
    }

    @Test
    public static void add() {
        List<String> list = new ArrayList<>();
        // add方法
        list.add("a");
        list.add("b");
        list.add(2, "c");

        // 迭代器的使用方法
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public static void clear() {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.clear();
        // 清除后list的size为0
        System.out.println(list.size());
    }

    @Test
    public static void contains() {
        List<String> list = new ArrayList<>();
        list.add("contains1");
        list.add("contains2");
        list.add("contains3");
        // 如果包含则返回true, 否则返回false
        System.out.println(list.contains("contains1"));
    }


}
