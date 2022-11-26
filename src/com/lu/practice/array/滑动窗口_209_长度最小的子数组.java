package com.lu.practice.array;

/**
 * @author lup
 * @create 2022/11/25 14:55
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其   和 ≥ s 的长度最小的 连续 子数组，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0。
 * 示例：
 * 输入：s = 7, nums = [2,3,1,2,4,3] 输出：2 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 */
public class 滑动窗口_209_长度最小的子数组 {

    //暴力解法 先从数组第一个元素累加之后的元素当满足条件更新最小长度，
    // 下一轮从第二个元素开始累加，过程更新最小长度
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= target) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    //滑动窗口，也可以看成双指针
    public static int minSubArrayLen2(int target, int[] nums) {
        int n = nums.length;
        int sum = 0;
        int left = 0;
        if (n == 0) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
          while (sum >= target){
             result = Math.min(result,right-left+1);
             sum -= nums[left++];
          }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }


    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        int result = minSubArrayLen2(target,nums);
        System.out.println(result);
    }
}
