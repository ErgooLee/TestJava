package com.xiaowuzei.test.algr.leet;

import java.util.Arrays;

public class N260_SingleNumberIII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new N260_SingleNumberIII().singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    }

    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int n : nums) {
            diff ^= n;
        }
        diff = Integer.highestOneBit(diff);
        int[] result = {0, 0};
        for (int num : nums) {
            //当前位是 0 的组, 然后组内异或
            if ((diff & num) == 0) {
                result[0] ^= num;
                //当前位是 1 的组
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }
}
