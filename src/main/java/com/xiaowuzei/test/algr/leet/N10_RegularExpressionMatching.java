package com.xiaowuzei.test.algr.leet;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class N10_RegularExpressionMatching {
    public static void main(String[] args) {
        System.out.println(new N10_RegularExpressionMatching().isMatch("aa", "a"));
        System.out.println(new N10_RegularExpressionMatching().isMatch("aa", "a*"));
        System.out.println(new N10_RegularExpressionMatching().isMatch("ab", ".*"));
        System.out.println(new N10_RegularExpressionMatching().isMatch("aab", "c*a*b"));
        System.out.println(new N10_RegularExpressionMatching().isMatch("mississippi", "mis*is*p*."));
        System.out.println(new N10_RegularExpressionMatching().isMatch("a", ".*"));
        System.out.println(new N10_RegularExpressionMatching().isMatch("aa", "a*aa"));
        System.out.println("-------------------");
        System.out.println(new N10_RegularExpressionMatching().isMatch2("aa", "a"));
        System.out.println(new N10_RegularExpressionMatching().isMatch2("aa", "a*"));
        System.out.println(new N10_RegularExpressionMatching().isMatch2("ab", ".*"));
        System.out.println(new N10_RegularExpressionMatching().isMatch2("aab", "c*a*b"));
        System.out.println(new N10_RegularExpressionMatching().isMatch2("mississippi", "mis*is*p*."));
        System.out.println(new N10_RegularExpressionMatching().isMatch2("a", ".*"));
        System.out.println(new N10_RegularExpressionMatching().isMatch2("aa", "a*aa"));
        System.out.println(new N10_RegularExpressionMatching().isMatch2("aa", "**"));
    }

    public boolean isMatch2(String s, String p) {
        return isMatch(s, 0, p, 0, new HashMap<>());
    }


    private static class Pair {
        int sStart;
        int pStart;

        public Pair(int sStart, int pStart) {
            this.sStart = sStart;
            this.pStart = pStart;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return sStart == pair.sStart &&
                    pStart == pair.pStart;
        }

        @Override
        public int hashCode() {
            return Objects.hash(sStart, pStart);
        }
    }


    private boolean isMatch(String s, int sStart, String p, int pStart, Map<Pair, Boolean> memo) {
        if (pStart == p.length()) {
            return sStart == s.length();
        }
        //s走完了  p没走完 还需要继续判定。
        Pair pair = new Pair(sStart, pStart);
        Boolean match = memo.get(pair);
        if (match != null) {
            return match;
        }
        match = sStart < s.length() && (s.charAt(sStart) == p.charAt(pStart) || p.charAt(pStart) == '.');
        if (pStart <= p.length() - 2 && p.charAt(pStart + 1) == '*') {
            //s走完了  p没走完 还需要继续判定，这是理由。
            match = isMatch(s, sStart, p, pStart + 2, memo) ||
                    (match && isMatch(s, sStart + 1, p, pStart, memo));
        } else {
            match = match && isMatch(s, sStart + 1, p, pStart + 1, memo);
        }
        memo.put(pair, match);
        return match;
    }


    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }


}
