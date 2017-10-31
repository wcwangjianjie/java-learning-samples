package com.wjj.algorithm;

/**
 * @author 作者：wangjj
 * @version 创建时间：2017-10-27 10:59
 * @discription 类说明：冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        //初始化长度为15的整数形数组
        int[] array = {22, 4, 100, 3, 90, 1, 54, 77, 14, 66, 55, 24, 8, 10, 62};
        //冒泡算法
        //从小到大排序
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1 -i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }

}
