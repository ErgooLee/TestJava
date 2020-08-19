package com.xiaowuzei.test.algr.leet;

import java.util.HashMap;
import java.util.Map;

public class N3_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(new N3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new N3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bbbb"));
        System.out.println(new N3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("dvdf"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int longestSize = 0;
        int left = 0;
        int right = 0;
        char tmpChar;
        Integer index;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            tmpChar = s.charAt(right);
            index = map.get(tmpChar);
            if (index != null) {
                while (left <= index) {
                    map.remove(s.charAt(left++));
                }
            }
            map.put(tmpChar, right);
            if (longestSize < map.size()) {
                longestSize = map.size();
            }
            right++;
        }

        return longestSize;
    }

}
