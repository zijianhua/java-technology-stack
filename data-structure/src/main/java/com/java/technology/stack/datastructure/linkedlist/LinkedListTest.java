package com.java.technology.stack.datastructure.linkedlist;

/**
 * @description:
 * @author: zjh
 * @create: 2019/05/31
 **/
public class LinkedListTest {

    public static void main(String[] args) {

        SinglyLinkedListTest();
    }

    /**
     * 单向链表测试
     */
    private static void SinglyLinkedListTest() {
        SinglyLinkedList linkedList = new SinglyLinkedList<String>();

        for (int i = 0; i < 10; i++) {
            linkedList.addBefore("before" + i);
        }
        for (int i = 0; i < 10; i++) {
            linkedList.addAfter("after" + i);
        }

        for (int i =0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }
    }
}