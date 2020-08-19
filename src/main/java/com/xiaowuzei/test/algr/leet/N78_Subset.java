package com.xiaowuzei.test.algr.leet;

import com.xiaowuzei.test.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class N78_Subset {

    public static void main(String[] args) {
        System.out.println(Utils.toString(new N78_Subset().subsets(new int[]{1, 2, 2})));
    }

    public List<List<Integer>> subsets2(int[] nums, int n) {
        List<List<Integer>> ret;
        if (n == -1) {
            ret = new ArrayList<>();
            ret.add(new ArrayList<>());
        } else {
            ret = subsets2(nums, n - 1);
            int size = ret.size();
            for (int i = 0; i < size; i++) {
                ret.add(new ArrayList<>(ret.get(i)));
            }
            for (int i = size; i < ret.size(); i++) {
                ret.get(i).add(nums[n]);
            }
        }
        return ret;
    }

    public List<List<Integer>> subsets(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        List<List<Integer>> ret = new ArrayList<>();
        subsets(nums, 0, stack, ret);
        return ret;
    }

    public void subsets(int[] nums, int n, Stack<Integer> stack, List<List<Integer>> all) {
        all.add(new ArrayList<>(stack));
        for (int i = n; i < nums.length; i++) {
            stack.add(nums[i]);
            subsets(nums, i + 1, stack, all);
            stack.remove(new Integer(nums[i]));
        }
    }


}
