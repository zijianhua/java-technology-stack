package com.java.technology.stack.datastructure.sort;

/**
 * @description: 选择排序
 * @author: zijianhua
 * @create: 2019/09/18
 **/
public class SelectSort {

    public void sort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int maxIndex;
        int maxTemp;
        for (int j = array.length - 1; j > 0; j--) {
            maxIndex = j;
            for (int i = 0; i < j; i++) {
                if (array[i] > array[maxIndex]) {
                    maxIndex = i;
                }
            }
            maxTemp = array[maxIndex];
            array[maxIndex] = array[j];
            array[j] = maxTemp;
        }
    }

}