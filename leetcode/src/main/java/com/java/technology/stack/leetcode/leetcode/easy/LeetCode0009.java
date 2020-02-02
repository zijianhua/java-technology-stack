package com.java.technology.stack.leetcode.leetcode.easy;

/**
 * @description: 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: zijh
 * @date: 2019-11-24 21:33
 **/
public class LeetCode0009 {

    public static void main(String[] args) {

        System.out.println(isPalindrome(123454321));
    }

    /**
     * 转换为字符串再处理
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        String xStr =  String.valueOf(x);
        if (xStr.length() < 2) {
            return true;
        }
        int count = xStr.length() / 2;
        boolean flag = true;
        for (int i = 0; i < count; i++) {
            if (!xStr.substring(i, i + 1).equals(xStr.substring(xStr.length() - 1 - i, xStr.length() - i))) {
                flag = false;
                continue;
            }
        }
        return flag;
    }


}
