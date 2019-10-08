package com.java.technology.stack.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: zijianhua
 * @create: 2019/05/31
 **/
public class Test {

    public static void main(String[] args) {
        List<Long> list = new ArrayList<Long>();
        list.add(0L);
        list.add(null);
        list.add(null);
        list.add(3L);
        for (Long a : list) {
            if (a != null) {
                System.out.println(a);
            }
        }
    }
}