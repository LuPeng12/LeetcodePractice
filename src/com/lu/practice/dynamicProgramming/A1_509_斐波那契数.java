package com.lu.practice.dynamicProgramming;

import java.time.Duration;
import java.time.Instant;

/**
 * @Author lupeng
 * @Date 2022/8/8
 */
public class A1_509_斐波那契数 {
    //常规递归思路
//   static int fib(int n){
//         if (n == 1|| n == 2){
//             return 1;
//         }
//         return fib(n-1)+fib(n-2);
//    }
    //带备忘录的解法,将递归中可能重复计算的节点存入备忘录中，可大幅提高性能
//   static int fib(int n){
//       if (n == 0){
//           return 0;
//       }
//         int[] memo = new int[n+1];
//         return helper(memo,n);
//    }
//   static int helper(int[] memo,int n){
//       if (n==1 || n==2){
//           return 1;
//       }
//
//       if (memo[n] != 0){
//           return memo[n];
//       }
//       memo[n] = helper(memo,n-1)+helper(memo,n-2);
//       return memo[n];
//    }
    //自底向上
//    static int fib(int N){
//        if (N == 0){
//            return 0;
//        }
//        int dp[] = new int[N+1];
//        dp[0] = 0;
//        dp[1] = 1;
//        for (int i = 2; i <= N; i++) {
//            dp[i] = dp[i-1]+dp[i-2];
//        }
//        return dp[N];
//    }
//优化，把空间复杂度降为 O(1)只需要结果所以不需要额外的数组空间
   static int fib(int n) {
        if (n == 0 || n == 1) {
            // base case
            return n;
        }
        // 分别代表 dp[i - 1] 和 dp[i - 2]
        int dp_i_1 = 1, dp_i_2 = 0;
        for (int i = 2; i <= n; i++) {
            // dp[i] = dp[i - 1] + dp[i - 2];
            int dp_i = dp_i_1 + dp_i_2;
            // 滚动更新
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i_1;
    }
    public static void main(String[] args) {
        Instant start = Instant.now();
        System.out.println(fib(20));
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("耗时"+timeElapsed);
    }
}
