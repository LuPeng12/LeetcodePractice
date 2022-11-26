package com.lu.practice.arrayTest;

/**
 * @Author lupeng
 * @Date 2022/9/30
 */
public class 二分法_35_搜索插入位置 {
    public static int searchInsert(int[] nums, int target) {
    int left = 0;
    int right = nums.length-1;
    int res = nums.length;
    while (left < right){
      int mid = left + (right - left)/2;
         if (mid == 0){
             return 1;
         }
        if (nums[mid] == target){
            res = mid;
            return mid;
        }else if (nums[mid] < target){
            res =
            left = mid;
        }else {
            right = mid;
        }
    }
    return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 2;
        int result = searchInsert(nums,target);
        System.out.println(result);
    }
}
