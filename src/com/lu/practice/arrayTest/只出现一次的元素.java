package com.lu.practice.arrayTest;

import java.util.*;

/**
 * @Author lupeng
 * @Date 2022/9/20
 */
public class 只出现一次的元素 {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3,4,4};
        findSingle(nums);
    }
    //异或，偶数次异或都为o，再异或奇数次等于本身 时间复杂度O(N),空间复杂度O(1)
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int num : nums) {
            res ^= num;
        }
        return res;
    }
    //链表处理，遍历后判断链表已存在则移除元素，用于删除偶数次元素保留奇数次
    private static void findSingle(int[] nums) {
        List<Integer> list =  new ArrayList<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])){
                boolean remove = list.remove(Integer.valueOf(nums[i]));
            }else {
              list.add(nums[i]);
            }
        }
        System.out.println(res);
        System.out.println(Collections.unmodifiableList(list));
    }
    /**
     初始：a=0,b=0
     x第一次出现时  a=(a^x)&(~b) = x,b=(b^x)&(~a) = 0
     第一次后：a=x,b=0
     x第二次出现时  a=(a^x)&(~b) = 0,b=(b^x)&(~a) = x
     第二次后：a=0,b=x
     x第三次出现时  a=(a^x)&(~b) = 0,b=(b^x)&(~a) = 0
     第三次后：a=0,b=0 ，回到了初始状态。

     当一个数第一次出现时，它的信息只保存在a中，第二次出现时它的信息只保留在b中，
     第三次出现时，a、b中均不在存在它的信息了。所以如果一个数组中只有一个数出现了1次，
     其余的数出现了3次，那么最终，a中就只保留着那出现一次的数了，直接返回a即可。
     */
    //只有一个数字出现了一次，其余数字出现了三次。
    public int singleNumber2(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            a = (a ^ num) & (~b);
            b = (b ^ num) & (~a);
        }
        return a;
    }
    //只有一个数字出现了两次，其余数字出现了三次。返回b即可
    //只有一个数字出现了一次，其余数字出现了四次。同理可得
    public int singleNumber3(int[] nums) {
        int a = 0, b = 0, c = 0;
        for (int num : nums) {
            a = (a ^ num) & (~b) & (~c);
            b = (b ^ num) & (~a) & (~c);
            c = (c ^ num) & (~a) & (~b);
        }
        return a;
    }


    //数组中有两个元素出现了1次，其余的数字出现了两次，找出这两个数。
    /**
     将数组分成两组，每组中只包含一个只出现一次的元素，
     这样就转化到第一题上了。那么怎么来分呢？首先将所有的数异或一下，这个数肯定不为0，
     那么找到它某一位为1的位，生成一个数字只在该位上为1，其余位上均为0,，
     然后我们将数组中的所有数字与该数相与，如果为0则分到一组，不为0则分到另一组。
     */
    public int[] singleNumber4(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        int rightOne = res & -res;// or Integer.lowestOneBit(res);
        int x = 0, y = 0;
        for (int num : nums) {
            if ((num & rightOne) == 1) {
                x ^= num;
            } else {
                y ^= num;
            }
        }
        return new int[]{x, y};
    }
    //通用解法
    // 只有一个数出现了k次，其余的数都出现了n次,这里需要 n > k
    public int singleNumber(int[] nums, int k, int n) {
        int[] bits = new int[32];
        for (int i = 0; i < 32; i++) {
            for (int num : nums) {
                bits[i] += (num >> i) & 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int num = bits[i];
            num %= n;
            num /= k;
            res += num << i;
        }
        return res;
    }
}
