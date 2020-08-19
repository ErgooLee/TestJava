package com.xiaowuzei.test.algr.leet;

public class N693_BinaryNumberWithAlternatingBits {
    public static void main(String[] args) {
        System.out.println(new N693_BinaryNumberWithAlternatingBits().hasAlternatingBits(5));
        System.out.println(new N693_BinaryNumberWithAlternatingBits().hasAlternatingBits(0));
    }

    public boolean hasAlternatingBits(int n) {
        boolean lastIs0 = (n & 1) == 0;
        n >>= 1;
        while (n != 0) {
            if (((n & 1) == 0) == lastIs0) {
                return false;
            } else {
                lastIs0 = !lastIs0;
                n >>= 1;
            }
        }
        return true;
    }


}
