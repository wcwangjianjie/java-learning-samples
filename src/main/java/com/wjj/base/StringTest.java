package com.wjj.base;

/**
 * @author 作者：wangjj
 * @version 版本：
 * @createTime 创建时间：2018-06-13 14:44
 * @discription 类说明：String类学习
 */
public class StringTest {
    public static void main(String[] args) {
        stringRegexTest("20.1");
        System.out.println("0123456789".substring(5));
        String stringTest = "\uD842\uDFB7";
        System.out.println(stringTest.codePoints());
        System.out.println("---------------------------------------");
        Object object = null;
        String price = String.valueOf(object);
        System.out.println("price:" + price);
    }

    /**
     * String 对象maches方法的使用
     * @param content
     */
    public static void stringRegexTest(String content) {
        System.out.println(content.matches("\"^(\\\\d)*.\\\\d$\""));
    }
}
