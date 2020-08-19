package com.xiaowuzei.test.algr.leet;

public class N201_BitwiseANDOfNumbersRange {
    public static void main(String[] args) {
//        System.out.println(new N201_BitwiseANDOfNumbersRange().rangeBitwiseAnd(5, 7));
//        System.out.println(new N201_BitwiseANDOfNumbersRange().rangeBitwiseAnd(0, 1));
        System.out.println(new N201_BitwiseANDOfNumbersRange().rangeBitwiseAnd(2147483646, 2147483647));
    }

    public int rangeBitwiseAnd2(int m, int n) {
        int ret = -1;
        for (int i = m; i <= n && ret != 0 && i >= 0; i++) {
            ret &= i;
        }
        return ret;
    }

    public int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            i += 1;
        }
        return n << i;
    }
}
