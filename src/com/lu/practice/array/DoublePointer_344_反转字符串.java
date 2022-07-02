package com.lu.practice.array;

/**
 * @Author lupeng
 * @Date 2022/7/2
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 使用 O(1) 的额外空间解决这一问题。
 */
public class DoublePointer_344_反转字符串 {
    public static void reverseString(char[] s) {
      int left = 0;
      int right = s.length-1;
      char temp = 0;
      while (left < right){
          temp =  s[left] ;
          s[left] = s[right];
          s[right] = temp;
          left++;
          right--;
      }
    }

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);

    }
}
