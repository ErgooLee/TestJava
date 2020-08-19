package com.xiaowuzei.test.algr.leet;

import com.xiaowuzei.test.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N15_3Sum {
    public static void main(String[] args) {
        System.out.println(Utils.toString(new N15_3Sum().threeSum(new int[]{-1, 0, 1, 2, -1, -4})));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        int length = nums.length;
        Arrays.sort(nums);
        int first, second, third, item, sum;
        for (first = 0; first < length; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            third = length - 1;
            second = first + 1;
            item = nums[first];
            while (second < third) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    second++;
                    continue;
                }
                sum = item + nums[second] + nums[third];
                if (sum < 0) {
                    second++;
                } else if (sum > 0) {
                    third--;
                } else {
                    List<Integer> list = new ArrayList<>(3);
                    list.add(item);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ret.add(list);
                    second++;
                    third--;
                }
            }
        }
        return ret;
    }
}
