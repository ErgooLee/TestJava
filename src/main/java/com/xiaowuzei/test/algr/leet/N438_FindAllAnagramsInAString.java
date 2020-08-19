package com.xiaowuzei.test.algr.leet;

import java.util.*;

public class N438_FindAllAnagramsInAString {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new N438_FindAllAnagramsInAString().findAnagrams("cbaebabacd", "abc").toArray()));
        System.out.println(Arrays.toString(new N438_FindAllAnagramsInAString().findAnagrams("abab", "ab").toArray()));
        System.out.println(Arrays.toString(new N438_FindAllAnagramsInAString().findAnagrams("", "a").toArray()));

    }

    static final class Pair {

        public int need;

        public Pair(int need, int window) {
            this.need = need;
            this.window = window;
        }

        public int window;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return ret;
        }

        int left = 0, right = p.length() - 1;

        Map<Character, Pair> map = new HashMap<>();
        char tmpChar;
        Pair tmpPair;

        for (int i = 0; i < p.length(); i++) {
            tmpChar = p.charAt(i);
            tmpPair = map.get(tmpChar);
            if (tmpPair == null) {
                tmpPair = new Pair(1, 0);
                map.put(tmpChar, tmpPair);
            } else {
                tmpPair.need++;
            }
        }

        for (int i = 0; i < p.length() - 1; i++) {
            tmpPair = map.get(s.charAt(i));
            if (tmpPair != null) {
                tmpPair.window++;
            }
        }

        while (right < s.length()) {
            tmpPair = map.get(s.charAt(right));
            if (tmpPair != null) {
                tmpPair.window++;
            }
            if (check(map)) {
                ret.add(left);
            }
            tmpPair = map.get(s.charAt(left));
            if (tmpPair != null) {
                tmpPair.window--;
            }
            left++;
            right++;
        }
        return ret;
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
