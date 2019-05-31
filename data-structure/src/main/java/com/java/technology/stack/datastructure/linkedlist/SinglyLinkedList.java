package com.java.technology.stack.datastructure.linkedlist;


/**
 * @description: 单向链表，包括带头节点和不带头节点，该类为不带头节点（头节点直接存储数据，和下一个节点的地址）
 * @author: zjh
 * @create: 2019/05/31
 **/
public class SinglyLinkedList<E> {
    /**
     * 计算链表长度
     */
    private int size;

    /**
     * 第一个数据节点
     */
    private Node<E> head;

    /**
     * 在链表头增加元素
     * 时间复杂度是O(1),空间复杂度是O(1)
     * @param e
     */
    public void addBefore(E e) {
        Node<E> node = new Node<E>(e);
        if (size == 0) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    /**
     * 在链尾部增加元素（单链表情况下，需要遍历整链表。因为找最后一个节点只能通过头部，一个个往下找）
     * 时间复杂度是O(n),空间复杂度是O(1)
     * @param e
     */
    public void addAfter(E e) {
        Node<E> node = new Node<E>(e);
        if (size == 0) {
            head = node;
            return;
        }
        Node<E> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
        size++;
    }

    /**
     * 根据指定下标获取元素
     * 时间复杂度是O(n),空间复杂度是O(1)
     * @param index
     */
    public E get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("index out of!");
        }
        int i = 0;
        Node<E> current = head;
        while (current != null && i < index){
            current = current.next;
            i++;
        }
        return current.data;
    }



    /**
     * 获取链表大小
     * 时间复杂度是O(1),空间复杂度是O(1)
     * @return
     */
    public int size() {
        return size;
    }








    private class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }

}
