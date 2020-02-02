package com.java.technology.stack.datastructure.array;


/**
 * @description: 数组相关操作
 * @author: zijh
 * @date: 2019-11-16 21:29
 **/
public class MyArray {

    private int[] array;
    private int size;

    public MyArray(int capacity) {
        this.array = new int[capacity];
        size = 0;
    }

    /**
     * 在指定位置插入元素
     *
     * @param index
     * @param element
     */
    public void insert(int index, int element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("插入元素位置超过了元素范围");
        }

        if (size >= array.length) {
            // 需要扩容

        }



    }


}
