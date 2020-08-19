package com.xiaowuzei.test.algr.leet;

import java.util.HashMap;
import java.util.Map;

public class N76_MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println("result: " + new N76_MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println("result: " + new N76_MinimumWindowSubstring().minWindow("aa", "aa"));
        System.out.println("result: " + new N76_MinimumWindowSubstring().minWindow("a", "aa"));
    }

    public String minWindow(String s, String t) {
        int left = 0, right = 0;
        Map<Character, Integer> requestChars = new HashMap<>();
        Map<Character, Integer> windowChars = new HashMap<>();
        for (char c : t.toCharArray()) {
            requestChars.merge(c, 1, Integer::sum);
            windowChars.put(c, 0);
        }
        char indexChar;
        Integer requestNum;
        Integer windowValue;
        int minLeft = 0;
        int minRight = 0;
        int minLength = Integer.MAX_VALUE;

        int requestDiffCharacter = requestChars.size();
        int windowSize = 0;

        while (right < s.length()) {

            while (right < s.length()) {
                indexChar = s.charAt(right);
                requestNum = requestChars.get(indexChar);
                if (requestNum != null) {
                    windowValue = windowChars.get(indexChar);
                    windowValue++;
                    windowChars.put(indexChar, windowValue);
                    if (windowValue.equals(requestNum)) {
                        windowSize++;
                    }
                }
                if (windowSize == requestDiffCharacter) {
                    break;
                } else {
                    right++;
                }
            }

            if (right < s.length()) {

                while (left <= right) {

                    if (minLength > right - left + 1) {
                        minLeft = left;
                        minRight = right;
                        minLength = minRight - minLeft + 1;
                    }

                    indexChar = s.charAt(left);
                    windowValue = windowChars.get(indexChar);
                    if (windowValue != null) {
                        windowValue--;
                        windowChars.put(indexChar, windowValue);
                        requestNum = requestChars.get(indexChar);
                        if (windowValue < requestNum) {
                            windowSize--;
                        }
                    }
                    left++;
                    if (windowSize < requestDiffCharacter) {
                        right++;
                        break;
                    }
                }
            }
        }

        if (minLength != Integer.MAX_VALUE) {
            return s.substring(minLeft, minRight + 1);
        } else {
            return "";
        }
    }
}
