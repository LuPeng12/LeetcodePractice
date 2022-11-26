package com.lu.practice.array;

import java.util.Arrays;

/**
 * @author lup
 * @create 2022/11/25 16:37
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 */
public class 遍历_59_螺旋矩阵2 {

    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        // 每次循环的开始点
        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = n-1;

        int count = 1;
        while (count <= n * n){

            // 模拟上侧从左到右
            for (int i = left; i <= right; i++) {
                result[top][i] = count++;
            }
             top++;
            // 模拟右侧从上到下
            for (int i = top; i <= bottom; i++) {
                result[i][right] = count++;
            }
            right--;
            // 模拟下侧从右到左
            for (int i = right; i >= left; i--) {
                result[bottom][i] = count++;
            }
            bottom--;
            // 模拟左侧从下到上
            for (int i = bottom; i >= top; i--) {
                result[i][left] = count++;
            }
            left++;
        }
             return result;
    }
    public static void main(String[] args) {
      int[][] result = generateMatrix(3);
        System.out.println(Arrays.deepToString(result));
    }
}
