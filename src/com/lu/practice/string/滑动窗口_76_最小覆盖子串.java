package com.lu.practice.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lupeng
 * @Date 2022/7/13
 * int left = 0, right = 0;
 *
 * while (right < s.size()) {
 *     // 增大窗口
 *     window.add(s[right]);
 *     right++;
 *
 *     while (window needs shrink) {
 *         // 缩小窗口
 *         window.remove(s[left]);
 *         left++;
 *     }
 * }
 *
 * void slidingWindow(string s) {
 *         unordered_map<char, int> window;
 *
 *         int left = 0, right = 0;
 *         while (right < s.size()) {
 *         // c 是将移入窗口的字符
 *         char c = s[right];
 *         // 增大窗口
 *         right++;
 *         // 进行窗口内数据的一系列更新
 *         ...
 *
 *         /*** debug 输出的位置
 *printf("window: [%d, %d)\n",left,right);
         *
         *
         *         // 判断左侧窗口是否要收缩
         *while(window needs shrink){
         *         // d 是将移出窗口的字符
         *char d=s[left];
         *         // 缩小窗口
         *left++;
         *         // 进行窗口内数据的一系列更新
         *...
         *}
         *}
         *}
 */


/* 滑动窗口算法框架 */

public class 滑动窗口_76_最小覆盖子串 {

    public static String minWindow(String s, String t) {
       char[] S = s.toCharArray();
       char[] T = t.toCharArray();
        Map<Character,Integer> need = new HashMap<>();
        for (int i = 0; i < T.length; i++) {
            char ch = t.charAt(i);
            need.put(ch,need.getOrDefault(ch,0)+1);
        }
        Map<Character,Integer> window = new HashMap<>();
       int len =Integer.MAX_VALUE;;
       int start = 0;
       int left = 0;
       int right = 0;
       int count = 0;
      // int first = t.length();
        while (right < s.length()){
            char ch = s.charAt(right);
            right++;
            if (need.containsKey(ch)){
                window.put(ch,window.getOrDefault( ch, 0 ) + 1);
                if ( window.get( ch ).equals( need.get( ch ) ) ) {
                    count++;
                }
            }
        }

        //判断左侧窗口是否收缩
        while (count == need.size()){
            // 在这里更新最小覆盖子串
            if ( right - left <  Integer.MAX_VALUE) {
                start = left;
                len = right - left;
            }
            char d= s.charAt(left);
            left++;
            if ( need.containsKey( d ) ) {
                if ( window.get( d ).equals( need.get( d ) ) ) {
                    count--;
                }
                window.put( d, window.get( d ) - 1 );
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring( left, start+len );

    }

    public static void main(String[] args) {
       String test = "ADOBECODEBANC";
       String t= "ABC";
       String res = minWindow(test,t);
        System.out.println(res);
    }
}
