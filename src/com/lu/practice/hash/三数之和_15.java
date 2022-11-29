package com.lu.practice.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lup
 * @create 2022/11/29 15:08
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
 * 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。
 *
 * 返回所有和为 0 且不重复的三元组。
 *
 */
public class 三数之和_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                return result;
            }

            if(i > 0 && nums[i] == nums[i-1]) {continue;}

            int left = i+1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                    while (right > left && nums[right] == nums[right - 1]) {right--;};
                    while (right > left && nums[left] == nums[left + 1]) {left++;};

                    right--;
                    left++;
                }
            }
        }
        return result;
    }
}
