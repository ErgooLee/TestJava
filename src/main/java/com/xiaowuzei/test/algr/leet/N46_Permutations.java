package com.xiaowuzei.test.algr.leet;

import java.util.ArrayList;
import java.util.List;

public class N46_Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> all = new ArrayList<>();
        findK(nums, 0, all);
        return all;
    }

    private void findK(int[] nums, int k, List<List<Integer>> all) {
        if (k == nums.length - 1) {
            List<Integer> list = new ArrayList<>(nums.length);
            for (int num : nums) {
                list.add(num);
            }
            all.add(list);
        }
        for (int i = k; i < nums.length; i++) {
            swap(nums, i, k);
            findK(nums, k + 1, all);
            swap(nums, i, k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
