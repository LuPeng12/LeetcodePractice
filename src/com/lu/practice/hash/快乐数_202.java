package com.lu.practice.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lup
 * @create 2022/11/28 16:27
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，
 * 也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 *
 * 题目中说了会 无限循环，那么也就是说求和的过程中，sum会重复出现
 */
public class 快乐数_202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)){
            set.add(n);
            n = getSum(n);
        }
        return n == 1;
    }

    private int getSum(int n){
        int res = 0;
        while (n > 0){
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }
}
