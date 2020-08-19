package com.xiaowuzei.test.algr.leet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class N1_TowSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new N1_TowSum().twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int num;
        for (int i = 0; i < nums.length; i++) {
            num = nums[i];
            Integer another = map.get(target - num);
            if (another != null) {
                return new int[]{another, i};
            } else {
                map.put(num, i);
            }
        }
        return new int[]{-1, -1};
    }
}

