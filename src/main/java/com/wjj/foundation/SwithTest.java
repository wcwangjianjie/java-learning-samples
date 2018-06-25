package com.wjj.foundation;

/**
 * @author 作者：wangjj
 * @version 版本：
 * @createTime 创建时间：2018-06-25 12:59
 * @discription 类说明：switch测试类
 */
public class SwithTest {
    public static void main(String args[]) {
        // switch如果没有break关键字，就会自动执行下一个case！！！  因此这里的结果为12
        char c = 'A' ;
        int num = 10 ;
        switch(c) {
            case 'B' :
                num ++ ;
            case 'A' :
                num ++ ;
            case 'Y' :
                num ++ ;
                break ;
            default :
                num -- ;
        }
        System.out.println(num) ;
    }
}
