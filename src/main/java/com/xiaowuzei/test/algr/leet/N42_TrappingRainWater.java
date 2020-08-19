package com.xiaowuzei.test.algr.leet;

public class N42_TrappingRainWater {

    public static void main(String[] args) {
        System.out.println(new N42_TrappingRainWater().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(new N42_TrappingRainWater().trap(new int[]{2, 0, 2}));
        System.out.println(new N42_TrappingRainWater().trap(new int[]{5, 4, 1, 2}));
        System.out.println(new N42_TrappingRainWater().trap(new int[]{5, 2, 1, 2, 1, 5}));
    }

    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int traps = 0;
        int left = height[0], right = height[1];
        int rightIndex = 1;
        int h, i, j;
        for (i = 1; i < height.length - 1; i++) {
            h = height[i];
            if (h >= left) {
                left = h;
            }
            if (rightIndex <= i) {
                right = h;
                rightIndex = i;
                for (j = i + 1; j < height.length; j++) {
                    if (height[j] > right) {
                        right = height[j];
                        rightIndex = j;
                    }
                }
            }
            traps += Math.min(left, right) - h;
        }
        return traps;
    }
}
