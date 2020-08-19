package com.xiaowuzei.test.algr.leet;

public class N5_LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(new N5_LongestPalindrome().longestPalindrome("babad"));
        System.out.println(new N5_LongestPalindrome().longestPalindrome("cbbd"));
    }

    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        int i, left, right, length = s.length(), testLength;
        int maxLeft = 0, maxLength = 1;
        for (i = 0; i < length; i++) {
            left = i;
            right = i;
            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            left++;
            right--;
            testLength = right - left + 1;
            if (maxLength < testLength) {
                maxLength = testLength;
                maxLeft = left;
            }
        }

        for (i = 0; i < length - 1; i++) {
            left = i;
            right = i + 1;
            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            left++;
            right--;
            testLength = right - left + 1;
            if (maxLength < testLength) {
                maxLength = testLength;
                maxLeft = left;
            }
        }
        return s.substring(maxLeft, maxLeft + maxLength);
    }

}
