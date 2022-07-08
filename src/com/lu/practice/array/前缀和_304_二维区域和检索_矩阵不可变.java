package com.lu.practice.array;

/**
 * @Author lupeng
 * @Date 2022/7/4
 */
public class 前缀和_304_二维区域和检索_矩阵不可变 {
    int[][] temp;
    public 前缀和_304_二维区域和检索_矩阵不可变(int[][] matrix) {
         int row = matrix.length;
         int col = matrix[0].length;
        temp = new int[row+1][col+1];
        for (int i = 1; i <=row ; i++) {
            for (int j = 1;j <=col; j++){
                temp[i][j] = temp[i-1][j]+temp[i][j-1]+matrix[i-1][j-1]-temp[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return temp[row2+1][col2+1] - temp[row1][col2+1] - temp[row2+1][col1] + temp[row1][col1];
    }

    public static void main(String[] args) {
        int [][] a={
            {1,1,1},
            {1,1,1},
            {1,1,1}
        };
        int b = new 前缀和_304_二维区域和检索_矩阵不可变(a).sumRegion(0,0,1,1);
        System.out.println(b);
    }
 }
