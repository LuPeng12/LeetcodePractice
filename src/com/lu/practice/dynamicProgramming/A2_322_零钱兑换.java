package com.lu.practice.dynamicProgramming;

import java.util.Arrays;

/**
 * @Author lupeng
 * @Date 2022/8/8
 * # 自顶向下递归的动态规划
 * def dp(状态1, 状态2, ...):
 *     for 选择 in 所有可能的选择:
 *         # 此时的状态已经因为做了选择而改变
 *         result = 求最值(result, dp(状态1, 状态2, ...))
 *     return result
 *
 * # 自底向上迭代的动态规划
 * # 初始化 base case
 * dp[0][0][...] = base case
 * # 进行状态转移
 * for 状态1 in 状态1的所有取值：
 *     for 状态2 in 状态2的所有取值：
 *         for ...
 *             dp[状态1][状态2][...] = 求最值(选择1，选择2...)
 */
public class A2_322_零钱兑换 {

    //自顶向下递归的动态规划
//    public static int coinChange(int[] coins, int amount) {
//
//       return  dp(coins,amount);
//    }
//    static int dp(int[] coins,int amount){
//
//        if (amount == 0){
//            return 0;
//        }
//        if (amount < 0){
//            return -1;
//        }
//        int res = Integer.MAX_VALUE;
//        for (int coin: coins) {
//            int sub = dp(coins,amount - coin);
//            if (sub == -1) continue;
//            res = Math.min(res,sub +1);
//        }
//        return res == Integer.MAX_VALUE? -1 :res;
//    }
//    public static void main(String[] args) {
//        int[] coins = new int[]{1,2,5};
//        System.out.println(coinChange(coins, 11));
//    }

    //自底向上迭代的动态规划
    public static int coinChange(int[] coins, int amount) {
       int[] dp = new int[amount+1];
       Arrays.fill(dp,amount+1);

            dp[0] = 0;      //dp 数组目标金额作为变量,dp[i]代表最少硬币数
            for (int i = 0; i < dp.length; i++) {
                for (int coin:coins) {
                    if (i - coin < 0){
                        continue;
                    }
                    dp[i] = Math.min(dp[i],1+dp[i-coin]);
                }
            }

       return  (dp[amount] == amount+1) ? -1 : dp[amount];
    }
}
