package com.lu.practice.test;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author lupeng
 * @Date 2022/9/16
 * like  abba   "dog cat cat dog" is true
 */
public class test12 {
    public static boolean wordPattern(String pattern, String teststr) {
        if (teststr == null) {
            return pattern == null;
        }
        BitSet b = new BitSet();
        Map<String, Character> map = new HashMap<>();
        String[] subStrAry = teststr.split(" ");
        for (int i = 0; i < subStrAry.length; i++) {
            char p = pattern.charAt(i);
            String str = subStrAry[i];
            Character hp = map.get(str);
            if (hp == null) {
                if (b.get(p)) {
                    return false;
                }
                map.put(str, p);
                b.set(p);
            } else {
                if (hp != p) {
                    return false;
                }
            }
        }

        return true;

    }
    public static void main(String[] args) {
        System.out.println(wordPattern("abba","dog cat cat dog"));
    }
}
