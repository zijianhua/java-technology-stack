package com.java.technology.stack.datastructure.sort;

/**
 * @description: 测试类
 * @author: zijianhua
 * @create: 2019/09/18
 **/
public class Test {

    public static void main(String[] args) {
        int[] array = new int[]{9,8,7,6,5,4,3,2,1};

        // 冒泡排序
        // BubbleSort bubbleSort = new BubbleSort();
        // bubbleSort.bubbleSort1(array);

        // 选择排序
        SelectSort selectSort = new SelectSort();
        selectSort.sort(array);

        for (int i : array) {
            System.out.println(i);
        }
    }
}