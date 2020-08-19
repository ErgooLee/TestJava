package com.xiaowuzei.test.algr.leet;

import java.util.Stack;

public class N20_ValidParentheses {
    public static void main(String[] args) {
        System.out.println(new N20_ValidParentheses().isValid("["));
        System.out.println(new N20_ValidParentheses().isValid(""));
        System.out.println(new N20_ValidParentheses().isValid("[]"));
        System.out.println(new N20_ValidParentheses().isValid("[]()"));
        System.out.println(new N20_ValidParentheses().isValid("[({})]"));
        System.out.println(new N20_ValidParentheses().isValid("[({)]"));
        System.out.println(new N20_ValidParentheses().isValid("]"));

    }

    public boolean isValid(String s) {
        char item;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            item = s.charAt(i);
            if (item == '(' || item == '[' || item == '{') {
                stack.add(item);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                switch (item) {
                    case ')':
                        if ('(' != stack.pop()) {
                            return false;
                        }
                        break;
                    case ']':
                        if ('[' != stack.pop()) {
                            return false;
                        }
                        break;
                    case '}':
                        if ('{' != stack.pop()) {
                            return false;
                        }
                        break;
                }
            }
        }
        return stack.isEmpty();
    }
}
