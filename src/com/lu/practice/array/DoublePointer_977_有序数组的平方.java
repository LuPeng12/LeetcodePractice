package com.lu.practice.array;

import java.util.Arrays;

/**
 * @author lup
 * @create 2022/11/25 14:29
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 */
public class DoublePointer_977_有序数组的平方 {

    //暴力解法
//    public static int[] sortedSquares(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = nums[i]*nums[i];
//        }
//        Arrays.sort(nums);
//        return nums;
//    }
    //双指针 数组其实是有序的， 只不过负数平方之后可能成为最大数了。
    //那么数组平方的最大值就在数组的两端，不是最左边就是最右边，不可能是中间。所以用两个指针指向两端
    public static int[] sortedSquares(int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = length-1;
        int[] result = new int[length];
        int index = length-1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[right]*nums[right] > nums[left]*nums[left]){
                result[index--] = nums[right]*nums[right];
                right--;
            }else {
                result[index--] = nums[left]*nums[left];
                left++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] a = {-4,-1,0,3,10};
        int[] result = sortedSquares(a);
        System.out.println(Arrays.toString(result));
    }
}
