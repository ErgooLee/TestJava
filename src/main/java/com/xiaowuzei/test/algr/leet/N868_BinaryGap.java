package com.xiaowuzei.test.algr.leet;

public class N868_BinaryGap {
    public static void main(String[] args) {
        System.out.println(new N868_BinaryGap().binaryGap(22));
        System.out.println(new N868_BinaryGap().binaryGap(5));
        System.out.println(new N868_BinaryGap().binaryGap(6));
        System.out.println(new N868_BinaryGap().binaryGap(8));
        System.out.println(new N868_BinaryGap().binaryGap(15));
    }

    public int binaryGap(int N) {
        int lastIndex = -1;
        int maxGap = 0;
        byte bitN;
        int index = 0;
        while (N != 0) {
            bitN = (byte) (N & 1);
            if (bitN == 1) {
                if (lastIndex != -1 && index - lastIndex > maxGap) {
                    maxGap = index - lastIndex;
                }
                lastIndex = index;
            }
            N >>= 1;
            index++;
        }
        return maxGap;
    }
}
