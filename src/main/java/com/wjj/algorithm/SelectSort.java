package com.wjj.algorithm;

/**
 * @author 作者：wangjj
 * @version 创建时间：2017-10-30 11:02
 * @discription 类说明：直接排序
 */
public class SelectSort {
    public static void main(String[] args) {
        //初始化长度为15的整数形数组
        int[] array = {22, 4, 100, 3, 90, 1, 54, 77, 14, 66, 55, 24, 8, 10, 62};
        //直接排序算法
        //从小到大排序
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}
