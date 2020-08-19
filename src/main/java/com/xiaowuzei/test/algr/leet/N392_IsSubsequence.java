package com.xiaowuzei.test.algr.leet;

public class N392_IsSubsequence {


    public static void main(String[] args) {
        System.out.println(new N392_IsSubsequence().isSubsequence("axc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }


}
