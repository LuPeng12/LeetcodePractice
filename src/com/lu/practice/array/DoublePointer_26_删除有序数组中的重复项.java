package com.lu.practice.array;

import java.util.stream.IntStream;

/**
 * @Author lupeng
 * @Date 2022/6/29
 *给你一个升序排列的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 *由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么nums的前 k 个元素应该保存最终结果。
 *将最终结果插入nums 的前 k 个位置后返回 k 。
 *不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2,_]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 */
public class DoublePointer_26_删除有序数组中的重复项 {
    public static int removeDuplicates(int[] nums) {
        int slow=0;
        int fast=1;
        while (fast < nums.length){
            if (nums[slow] != nums[fast]){
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow+1;           //因其原数组为排序后，重复项紧邻， 快慢指针解决，最后的结果数组就时0-slow的结果
    }

    public static void main(String[] args) {
        int[] nums = {1,1,3,5,5,6};
        int k = removeDuplicates(nums);
        System.out.println(k);
    }
}
