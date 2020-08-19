package com.xiaowuzei.test.algr.leet;

public class N405_ConvertANumberToHexadecimal {
    public static void main(String[] args) {
        System.out.println(new N405_ConvertANumberToHexadecimal().toHex(-1));
    }


    public String toHex(int num) {
        char[] chars = new char[8];
        char tmp;
        for (int i = 0; i < 8; i++) {
            tmp = (char) (num & 15);
            if (tmp <= 9) {
                tmp = (char) ('0' + tmp);
            } else {
                tmp = (char) ('a' + tmp - 10);
            }
            chars[7 - i] = tmp;
            num = num >> 4;
        }
        StringBuilder sb = new StringBuilder();
        boolean nonZero = false;
        for (int i = 0; i < 8; i++) {
            tmp = chars[i];
            if (tmp != '0') {
                nonZero = true;
                sb.append(tmp);
            } else if (nonZero) {
                sb.append(tmp);
            }
        }
        if (!nonZero) {
            sb.append('0');
        }
        return sb.toString();
    }
}
