package com.xiaowuzei.test.algr.leet;

import java.util.HashMap;
import java.util.Map;

public class N560_SubArraySumEqualsK {

    public static void main(String[] args) {
        System.out.println(new N560_SubArraySumEqualsK().subarraySum(new int[]{1, 2, 3, 4, 5, 6, 7}, 9));
        System.out.println(new N560_SubArraySumEqualsK().subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(new N560_SubArraySumEqualsK().subarraySum(new int[]{1}, 1));
    }

    //滑动窗口
    public int subarraySum2(int[] nums, int k) {
        int subArrayLength = 1;
        int N = nums.length;
        int sum = nums[0];
        int i;
        int count = 0;
        if (sum == k) {
            count++;
        }
        boolean toRight = false;
        while (subArrayLength < N) {
            toRight = !toRight;

            for (i = 0; i <= N - subArrayLength; i++) {
                if (toRight) {
                    if (i != N - subArrayLength) {
                        sum -= nums[i];
                        sum += nums[i + subArrayLength];
                    } else {
                        sum += nums[N - 1 - subArrayLength];
                    }
                } else {
                    if (i != N - subArrayLength) {
                        sum -= nums[N - 1 - i];
                        sum += nums[N - 1 - i - subArrayLength];
                    } else {
                        sum += nums[subArrayLength];
                    }
                }
                if (sum == k) {
                    count++;
                }
            }
            subArrayLength++;
        }
        return count;
    }

    //
    public int subarraySum1(int[] nums, int k) {
        int N = nums.length;
        int[] preSum = new int[N + 1];
        int count = 0;
        for (int i = 0; i < N; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (preSum[j] - preSum[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }


    //前缀和相减就是连续子和
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum_0_i = 0;
        for (int num : nums) {
            sum_0_i += num;
            count += map.getOrDefault(sum_0_i - k, 0);
            map.put(sum_0_i, map.getOrDefault(sum_0_i, 0) + 1);
        }
        return count;
    }

}
