package com.lu.practice.string;


/**
 * @author lup
 * @create 2022/11/29 19:18
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样
 */
public class 反转字符串Ⅱ_541 {
    public String reverseStr(String s, int k) {
      char[] res = s.toCharArray();
      int nums = res.length;
      int start = 0;
       while (start < nums){
           if (start + k > nums){
               reverseString(res,start,nums-1);
           }else {
               reverseString(res,start,start+k-1);
           }
           start = start + 2*k;                   //重点就是在所以当需要固定规律一段一段去处理字符串的时候，要想想在在for循环的表达式上做做文章。
       }
       return String.valueOf(res);
    }
    public void reverseString(char[] s,int left,int right) {
        char temp;
        while (left < right){
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
