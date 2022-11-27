package com.lu.practice.hash;

/**
 * @author lup
 * @create 2022/11/27 16:46
 */
public class 有效的字母异位词_242 {

    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];

        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }

        for (int count: record) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        char a = 'a';
        Integer b = (int) a;
        System.out.println(b);
    }
}
