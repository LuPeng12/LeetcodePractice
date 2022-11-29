package com.lu.practice.string;

import java.util.Arrays;

/**
 * @author lup
 * @create 2022/11/29 18:53
 */
public class DoublePointer_344_反转字符串 {
    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        char temp;
        while (left < right){
          temp = s[left];
          s[left] = s[right];
          s[right] = temp;

          //通过异或运算交换，假如交换a，b 那么令a = a 异或 b ,那么令 b = (a 异或 b) 异或 b = a , a = (a 异或 b) 异或 a = b
//          s[left] ^= s[right];
//          s[right] ^= s[left];
//          s[left] ^= s[right];

          left++;
          right--;
        }
        System.out.println(Arrays.toString(s));
    }

    public static void main(String[] args) {
        char[] a = {'h','e','l','l','o'};
        reverseString(a);
    }
}
