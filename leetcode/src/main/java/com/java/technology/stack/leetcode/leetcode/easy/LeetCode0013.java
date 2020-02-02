package com.java.technology.stack.leetcode.leetcode.easy;

import com.sun.tools.javac.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 罗马数字转整数
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 *
 * "MCMXCIV"
 * 1000+900+90+4 = 1994
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: zijh
 * @date: 2019-11-24 21:33
 **/
public class LeetCode0013 {

    private static final Map<String, Integer> ROMAN_MAP;
    private static final Map<String, Integer> ROMAN_MAP_2;

    static
    {
        ROMAN_MAP = new HashMap<>();
        ROMAN_MAP.put("I", 1);
        ROMAN_MAP.put("V", 5);
        ROMAN_MAP.put("X", 10);
        ROMAN_MAP.put("L", 50);
        ROMAN_MAP.put("C", 100);
        ROMAN_MAP.put("D", 500);
        ROMAN_MAP.put("M", 1000);
        ROMAN_MAP.put("IV", 4);
        ROMAN_MAP.put("IX", 9);
        ROMAN_MAP.put("XL", 40);
        ROMAN_MAP.put("XC", 90);
        ROMAN_MAP.put("CD", 400);
        ROMAN_MAP.put("CM", 900);

        ROMAN_MAP_2 = new HashMap<>();
        ROMAN_MAP_2.put("I", 1);
        ROMAN_MAP_2.put("V", 5);
        ROMAN_MAP_2.put("X", 10);
        ROMAN_MAP_2.put("L", 50);
        ROMAN_MAP_2.put("C", 100);
        ROMAN_MAP_2.put("D", 500);
        ROMAN_MAP_2.put("M", 1000);
        ROMAN_MAP_2.put("IV", 3);
        ROMAN_MAP_2.put("IX", 8);
        ROMAN_MAP_2.put("XL", 30);
        ROMAN_MAP_2.put("XC", 80);
        ROMAN_MAP_2.put("CD", 300);
        ROMAN_MAP_2.put("CM", 800);
    }

    public static void main(String[] args) {

        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt2("MCMXCIV"));
        System.out.println(romanToInt3("MCMXCIV"));
    }

    /**
     * 罗马数字转整数
     *
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        int result = 0;
        if (s == null || s.isEmpty()) {
            return result;
        }

        int strLength = s.length();
        Integer tempValue;
        Integer tempOldValue;
        for (int i = 0; i < strLength; i++) {
            tempValue = null;
            tempOldValue = null;
            if (i - 1 >= 0) {
                tempOldValue = ROMAN_MAP.get(s.substring(i - 1, i + 1));
            }
            if (tempOldValue != null) {
                continue;
            }
            if (i + 2 <= strLength) {
                tempValue = ROMAN_MAP.get(s.substring(i, i + 2));
            }

            if (tempValue != null) {
                result = result + tempValue;
            } else {
                tempValue = ROMAN_MAP.get(s.substring(i, i + 1));
                if (tempValue == null) {
                    result = 0;
                    break;
                }
                result = result + tempValue;
            }

        }

        return result;
    }

    public static int romanToInt2(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Integer tempValue = ROMAN_MAP_2.get(s.substring(0, 1));
        if (tempValue == null) {
            return 0;
        }
        int result = tempValue;
        for (int i = 1; i < s.length(); i++) {
            tempValue = ROMAN_MAP_2.get(s.substring(i - 1, i + 1));

            if (tempValue != null) {
                result = result + tempValue;
                continue;
            }

            tempValue = ROMAN_MAP_2.get(s.substring(i, i + 1));
            if (tempValue == null) {
                result = 0;
                break;
            }
            result = result + tempValue;
        }

        return result;
    }

    public static int romanToInt3(String s) {
        int result = 0;
        if (s == null || s.isEmpty()) {
            return result;
        }
        int preValue = getValue(s.charAt(0));
        if (preValue == 0) {
            return result;
        }
        result = preValue;
        for (int i = 1; i < s.length(); i++) {
            int tempValue = getValue(s.charAt(i));
            if (preValue < tempValue) {
                result = result + tempValue - (2 * preValue);
            } else {
                result += tempValue;
            }
            preValue = tempValue;
        }
        return result;
    }

    private static int getValue(char str) {
        int result;
        switch (str) {
            case 'I':
                result = 1;
                break;
            case 'V':
                result = 5;
                break;
            case 'X':
                result = 10;
                break;
            case 'L':
                result = 50;
                break;
            case 'C':
                result = 100;
                break;
            case 'D':
                result = 500;
                break;
            case 'M':
                result = 1000;
                break;
            default:
                result = 0;
                break;
        }
        return result;
    }



}
