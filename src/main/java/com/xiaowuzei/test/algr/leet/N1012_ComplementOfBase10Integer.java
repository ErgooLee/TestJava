package com.xiaowuzei.test.algr.leet;

public class N1012_ComplementOfBase10Integer {
    public static void main(String[] args) {
        System.out.println(new N1012_ComplementOfBase10Integer().bitwiseComplement(0));
    }

    public int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }
        int maxBit = 0;
        int tmpNum = N;
        int mark;
        while (tmpNum != 0) {
            tmpNum >>= 1;
            maxBit++;
        }
        if (maxBit == 31) {
            mark = 0x7fffffff;
        } else {
            mark = (1 << maxBit) - 1;
        }
        return N ^ mark;
    }

}
