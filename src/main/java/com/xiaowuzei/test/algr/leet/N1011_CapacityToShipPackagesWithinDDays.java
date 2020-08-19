package com.xiaowuzei.test.algr.leet;

public class N1011_CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        System.out.println(new N1011_CapacityToShipPackagesWithinDDays().shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3));
        System.out.println(new N1011_CapacityToShipPackagesWithinDDays().shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4));
        System.out.println(new N1011_CapacityToShipPackagesWithinDDays().shipWithinDays(new int[]{1, 2, 3, 1, 1}, 10));
        System.out.println(new N1011_CapacityToShipPackagesWithinDDays().shipWithinDays(new int[]{3}, 1));
    }

    public int shipWithinDays(int[] weights, int D) {
        int left = 1;
        int right = 50_000 * 500 + 1;
        int days;
        int count;
        boolean available;
        int mid;
        int i;
        int tmp;
        while (left < right) {
            available = true;
            mid = left + (right - left) / 2;
            days = 0;
            count = 0;

            for (i = 0; i < weights.length; ) {
                tmp = weights[i];
                count += tmp;
                if (count > mid) {
                    count = 0;
                    days++;
                    if (days > D) {
                        available = false;
                        break;
                    }
                } else {
                    i++;
                }
            }
            if (available && count != 0 && ++days > D) {
                available = false;
            }

            if (available) {
                if (days == 1) {
                    right = count;
                } else {
                    right = mid;
                }
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
