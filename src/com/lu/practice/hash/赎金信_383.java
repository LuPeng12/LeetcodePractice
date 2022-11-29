package com.lu.practice.hash;

/**
 * @author lup
 * @create 2022/11/29 14:50
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 *
 * 如果可以，返回 true ；否则返回 false 。
 *
 */
public class 赎金信_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] record = new int[26];

        for (int i = 0; i < ransomNote.length(); i++) {
            record[ransomNote.charAt(i) - 'a']++;
        }

        for (int i = 0; i < magazine.length(); i++) {
            if (record[magazine.charAt(i)  - 'a'] > 0){
                record[magazine.charAt(i) - 'a']--;
            }
        }
        for (int count: record) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] record = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            record[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            record[ransomNote.charAt(i) - 'a']--;
        }
        // 如果数组中存在负数，说明ransomNote字符串总存在magazine中没有的字符
        for (int count: record) {
            if (count < 0) {
                return false;
            }
        }
        return true;
    }
}
