package com.xiaowuzei.test.algr.leet;

public class N990_SatisfiabilityOfEqualityEquations {
    public static void main(String[] args) {
        System.out.println(new N990_SatisfiabilityOfEqualityEquations().equationsPossible(new String[]{"a==b", "b!=a"}));
        System.out.println(new N990_SatisfiabilityOfEqualityEquations().equationsPossible(new String[]{"c==c", "b==d", "x!=z"}));
    }

    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind(26);
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                unionFind.union(equation.charAt(0) - 'a', equation.charAt(3) - 'a');
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!'
                    && unionFind.isConnected(equation.charAt(0) - 'a', equation.charAt(3) - 'a')) {
                return false;
            }
        }
        return true;
    }
}
