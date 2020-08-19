package com.xiaowuzei.test.algr.leet;

public class N1442_CountTripletsThatCanFormTwoArraysOfEqualXOR {
    public static void main(String[] args) {
        System.out.println(new N1442_CountTripletsThatCanFormTwoArraysOfEqualXOR().countTriplets(new int[]{2, 3, 1, 6, 7}));
    }

    public int countTriplets(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            for (int k = i + 1; k < arr.length; k++) {
                temp ^= arr[k];
                if (temp == 0) {
                    count += k - i;
                }
            }
        }
        return count;
    }
}
