package com.xiaowuzei.test.algr.leet;


import java.util.HashMap;
import java.util.Map;

public class N567_PermutationInString {
    public static void main(String[] args) {
        System.out.println(new N567_PermutationInString().checkInclusion("ab", "eidbaooo"));
        System.out.println(new N567_PermutationInString().checkInclusion("ab", "eidboaoo"));
        System.out.println(new N567_PermutationInString().checkInclusion("ab", "ab"));
    }

    static final class Pair {
        public int need;

        public Pair(int need, int window) {
            this.need = need;
            this.window = window;
        }

        public int window;
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int left = 0, right = s1.length() - 1;

        Map<Character, Pair> map = new HashMap<>();
        char tmpChar;
        Pair tmpPair;

        for (int i = 0; i < s1.length(); i++) {
            tmpChar = s1.charAt(i);
            tmpPair = map.get(tmpChar);
            if (tmpPair == null) {
                tmpPair = new Pair(1, 0);
                map.put(tmpChar, tmpPair);
            } else {
                tmpPair.need = tmpPair.need + 1;
            }
        }

        for (int i = 0; i < s1.length() - 1; i++) {
            tmpPair = map.get(s2.charAt(i));
            if (tmpPair != null) {
                tmpPair.window = tmpPair.window + 1;
            }
        }

        while (right < s2.length()) {
            tmpPair = map.get(s2.charAt(right));
            if (tmpPair != null) {
                tmpPair.window++;
            }
            if (check(map)) {
                return true;
            }
            tmpPair = map.get(s2.charAt(left));
            if (tmpPair != null) {
                tmpPair.window--;
            }
            left++;
            right++;
        }

        return false;
    }


    private boolean check(Map<Character, Pair> map) {
        for (Map.Entry<Character, Pair> characterPairEntry : map.entrySet()) {
            Pair pair = characterPairEntry.getValue();
            if (pair.need != pair.window) {
                return false;
            }
        }
        return true;
    }

}
