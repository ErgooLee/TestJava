package com.xiaowuzei.test.algr.leet;

public class N43_MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(new N43_MultiplyStrings().multiply("123", "645"));
        System.out.println(new N43_MultiplyStrings().multiply("123", "0"));
    }

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int n1 = num1.length();
        int n2 = num2.length();
        char[] result = new char[n1 + n2];
        int product;
        int carry;
        int index;
        int i, j;
        for (i = n1 - 1; i >= 0; i--) {
            for (j = n2 - 1; j >= 0; j--) {
                index = i + j + 1;
                product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                product += result[index];
                carry = product / 10;
                result[index] = (char) (product % 10);
                index--;
                while (carry != 0) {
                    product = result[index] + carry;
                    result[index] = (char) (product % 10);
                    carry = product / 10;
                    index--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (result[0] == 0) {
            i = 1;
        } else {
            i = 0;
        }
        for (; i < n1 + n2; i++) {
            sb.append((char) (result[i] + '0'));
        }
        return sb.toString();
    }
}
