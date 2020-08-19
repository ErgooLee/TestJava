package com.xiaowuzei.test.algr.backtrack;

import java.util.*;
import java.util.stream.Collectors;

public class FullArrangement {

    public static void main(String[] args) {
        new FullArrangement().fullArrangement(new int[]{1, 2, 3});
    }

    private void fullArrangement(int[] nums) {
        System.out.println("method 1---------------");
        findK(nums, 0);
        System.out.println("method 2---------------");
        findK2(nums, new HashSet<>(), new int[nums.length], 0);
    }

    private void findK(int[] nums, int k) {
        if (k == nums.length - 1) {
            System.out.println(Arrays.toString(nums));
        }
        for (int i = k; i < nums.length; i++) {
            swap(nums, i, k);
            findK(nums, k + 1);
            swap(nums, i, k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void findK2(int[] nums, Set<Integer> visited, int[] result, int k) {
        if (k == result.length) {
            System.out.println(Arrays.toString(result));
            Arrays.stream(nums).boxed().collect(Collectors.toList());
            return;
        }
        for (int num : nums) {
            if (visited.contains(num)) {
                continue;
            }
            result[k] = num;
            visited.add(num);
            findK2(nums, visited, result, k + 1);
            visited.remove(num);
        }
    }


}
