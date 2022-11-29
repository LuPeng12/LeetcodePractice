package com.lu.practice.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lup
 * @create 2022/11/28 16:48
 */
public class 两数之和_1 {
    public int[] twoSum(int[] nums, int target) {
     int[] res = new int[2];
     if (nums == null || nums.length == 0){
         return res;
     }

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (map.containsKey(need)){
                res[0] = i;
                res[1] = map.get(need);
                break;
            }
            map.put(nums[i],i);
        }
        return res;
    }
}
