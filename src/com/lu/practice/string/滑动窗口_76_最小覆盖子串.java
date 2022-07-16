package com.lu.practice.string;

/**
 * @Author lupeng
 * @Date 2022/7/13
 */
public class 滑动窗口_76_最小覆盖子串 {

    public static String minWindow(String s, String t) {
       char[] original = s.toCharArray();
       char[] originalR = t.toCharArray();
       int l = t.length();
       char[] result = {};
        for (int i = 0; i <4 ; i++) {
            System.out.println("1111");
        }
    return null;
    }

    public static void main(String[] args) {
       String test = "ADOBECODEBANC";
       String t= "ABC";
       String res = minWindow(test,t);
    }
}
