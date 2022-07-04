package com.lu.practice.array;

/**
 * @Author lupeng
 * @Date 2022/7/4
 * 计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
 */
public class 前缀和_303_区域和检索 {
    int[] temp;
    public 前缀和_303_区域和检索(int[] nums) {
        temp=new int[nums.length+1];
        temp[0] = 0;
        for (int i = 0;i < nums.length;i++){
            temp[i+1] = temp[i]+nums[i];
        }
    }

    public int sumRange(int left, int right) {
        int result = temp[right+1]-temp[left];
        return result;
    }
}
