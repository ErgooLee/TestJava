package com.xiaowuzei.test.algr.leet;

public class N371_SumOfTwoIntegers {
    public static void main(String[] args) {
        System.out.println(new N371_SumOfTwoIntegers().getSum(-1, -1));
    }


    public int getSum(int a, int b) {
        int lower;
        int carrier;
        while (true) {
            lower = a ^ b;    // 计算低位
            carrier = a & b;  // 计算进位
            if (carrier == 0) break;
            a = lower;
            b = carrier << 1;
        }
        return lower;
    }
}
