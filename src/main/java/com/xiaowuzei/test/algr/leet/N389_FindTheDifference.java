package com.xiaowuzei.test.algr.leet;

public class N389_FindTheDifference {
    public static void main(String[] args) {
        System.out.println(new N389_FindTheDifference().findTheDifference("abcd", "abcde"));
    }

    public char findTheDifference(String s, String t) {
        byte ret = 0;
        for (byte aByte : s.getBytes()) {
            ret ^= aByte;
        }
        for (byte aByte : t.getBytes()) {
            ret ^= aByte;
        }
        return ((char) ret);
    }

}
