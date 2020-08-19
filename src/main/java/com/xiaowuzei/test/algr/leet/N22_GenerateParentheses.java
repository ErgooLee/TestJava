package com.xiaowuzei.test.algr.leet;

import java.util.ArrayList;
import java.util.List;

public class N22_GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(new N22_GenerateParentheses().generateParenthesis(3));
    }


    int n;
    List<String> ret;
    char[] array;
    char[] selections = new char[]{'(', ')'};
    int left = 0;
    int right = 0;

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        this.n = n;
        this.array = new char[2 * n];
        this.ret = new ArrayList<>();
        backTrace(0);
        return ret;
    }


    public void backTrace(int index) {
        if (index == 2 * n) {
            ret.add(new String(array));
            return;
        }
        for (char selection : selections) {
            if (valid(selection)) {
                array[index] = selection;
                record(selection);
                backTrace(index + 1);
                clear(selection);
            }
        }
    }

    boolean valid(char selection) {
        int tmpLeft = left;
        int tmpRight = right;
        if (selection == '(') {
            tmpLeft++;
        } else {
            tmpRight++;
        }
        return tmpLeft >= tmpRight && tmpLeft <= n;
    }

    void record(char select) {
        if (select == '(') {
            left++;
        } else {
            right++;
        }
    }

    void clear(char select) {
        if (select == '(') {
            left--;
        } else {
            right--;
        }
    }


}
