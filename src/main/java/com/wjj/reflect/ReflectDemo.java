package com.wjj.reflect;

import com.wjj.temp.Person;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author 作者：wangjj
 * @version 版本：
 * @createTime 创建时间：2019-07-15 15:54
 * @discription 类说明：反射用例
 */
public class ReflectDemo {

    public static void main(String[] args) {
        Class person = Person.class;

        Field[] fields = person.getDeclaredFields();
        /*Arrays.stream(fields).forEach(System.out::println);
        Arrays.stream(fields).forEach(x -> System.out.println(x.getName()));*/

        System.out.println("------------------------------");

        Method[] methods = person.getDeclaredMethods();
        Arrays.stream(methods).forEach(System.out::println);
        Arrays.stream(methods).forEach(x -> System.out.println(x.getName()));
    }
}
