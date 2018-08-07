package com.wjj.base;

/**
 * @author 作者：wangjj
 * @version 版本：
 * @createTime 创建时间：2018-06-13 14:45
 * @discription 类说明：
 */
public class StringBuilderTest {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("abc");
        System.out.println(stringBuilder.length());

        stringBuilder.appendCodePoint(98);
        System.out.println(stringBuilder.toString());
    }
}
