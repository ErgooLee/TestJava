package com.xiaowuzei.test.algr.leet;


public class N875_KokoEatingBananas {

    public static void main(String[] args) {
        System.out.println(new N875_KokoEatingBananas().minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        System.out.println(new N875_KokoEatingBananas().minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
        System.out.println(new N875_KokoEatingBananas().minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
        System.out.println(new N875_KokoEatingBananas().minEatingSpeed(new int[]{332484035,
                        524908576,
                        855865114,
                        632922376,
                        222257295,
                        690155293,
                        112677673,
                        679580077,
                        337406589,
                        290818316,
                        877337160,
                        901728858,
                        679284947,
                        688210097,
                        692137887,
                        718203285,
                        629455728,
                        941802184},
                823855818));
    }

    public int minEatingSpeed(int[] piles, int H) {
        int left = 1;
        int right = 1_000_000_000 + 1;
        boolean canFinish;
        int count;
        while (left < right) {
            int mid = left + (right - left) / 2;
            count = 0;
            canFinish = true;
            for (int pile : piles) {
                count += (pile - 1) / mid + 1;
                if (count > H) {
                    canFinish = false;
                }
            }
            if (canFinish) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
