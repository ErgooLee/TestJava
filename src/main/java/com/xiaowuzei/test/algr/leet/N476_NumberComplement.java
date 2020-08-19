package com.xiaowuzei.test.algr.leet;

public class N476_NumberComplement {
    public static void main(String[] args) {
        System.out.println(new N476_NumberComplement().findComplement(5));
        System.out.println(new N476_NumberComplement().findComplement(7));
    }

    public int findComplement(int num) {
        int maxBit = 0;
        int tmpNum = num;
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
        return num ^ mark;
    }

}
