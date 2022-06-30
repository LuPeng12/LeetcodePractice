package com.lu.practice.array;

import java.util.stream.IntStream;

/**
 * @Author lupeng
 * @Date 2022/6/30
 * 给你一个下标从 1 开始的整数数组numbers ，该数组已按 非递减顺序排列 ，请你从数组中找出满足相加之和等于目标数target 的两个数。
 * 如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 *
 */
public class DoublePointer_167_两数之和 {

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        int[] result=new int[2];
        while (left < right){
            if (numbers[left] + numbers[right] > target){
                  right--;
            }else if (numbers[left] + numbers[right] < target){
                  left++;
            }else{
                result[0] = left+1;      //题目下标从1开始
                result[1] = right+1;
                return result;
            }

        }
          return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = twoSum(nums,target);
        IntStream.of(result).forEach(System.out::println);
    }

}
