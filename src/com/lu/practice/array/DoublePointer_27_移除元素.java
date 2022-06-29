package com.lu.practice.array;

/**
 * @Author lupeng
 * @Date 2022/6/29
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 */
public class DoublePointer_27_移除元素 {
    public static int removeElement(int[] nums, int val) {
        int slow=0;
        int fast=0;
        while (fast < nums.length){
            if (nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
      return slow;                   //不用返回slow+1
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int k = removeElement(nums,3);
        System.out.println(k);
    }
}
