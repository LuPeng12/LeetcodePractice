package com.lu.practice.string;

/**
 * @author lup
 * @create 2022/11/30 8:02
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回 -1 。
 *
 *
 */
public class 找出字符串中第一个匹配项的下标_28 {
    //暴力求解，显示匹配/隐式匹配
    public int strStr(String haystack, String needle) {
        int lengthA = haystack.length();
        int lengthP = needle.length();

        for (int i = 0; i < lengthA ; i++) {
            for (int j = 0; j < lengthP; j++) {
                //外层for循环 判断条件可直接写为i <= lengthA - lengthP
                if(i+j > lengthA-1){
                    return -1;
                }

                if (haystack.charAt(i+j) != needle.charAt(j)){
                    break;
                }

                if (j == lengthP-1){
                    return i;
                }
            }
        }
        return -1;
    }
}
