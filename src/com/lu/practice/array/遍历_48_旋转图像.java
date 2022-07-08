package com.lu.practice.array;

/**
 * @Author lupeng
 * @Date 2022/7/8
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 1.按对角线反转
 * 2.二维数组的每一行反转
 * 3.得到顺时针旋转 90 度
 * 注：按对角线反转时，遍历只需要单边的三角
 */
public class 遍历_48_旋转图像 {

    public static void rotate(int[][] matrix) {
        int col = matrix.length;
        int temp = 0;
        for (int i = 0; i < col; i++) {
            for (int j = i; j < col; j++) {
               temp = matrix[i][j];
               matrix[i][j] = matrix[j][i];
               matrix[j][i] = temp;
            }
        }
        for (int[] arr: matrix) {
            reverse(arr);
        }
    }
    //反转
    static void reverse(int[] arr){
        int left = 0;
        int right = arr.length -1;
        while (left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        int[][] o = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(o);
    }
}
