package com.xiaowuzei.test.algr.leet;

import java.util.*;

public class N752_OpenTheLock {


    public static void main(String[] args) {
//        System.out.println("steps: " + new N752_OpenTheLock().openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
//        System.out.println("steps: " + new N752_OpenTheLock().openLock(new String[]{"8888"}, "0009"));
//        System.out.println("steps: " + new N752_OpenTheLock().openLock(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888"));
        System.out.println("steps: " + new N752_OpenTheLock().openLock(new String[]{"0000"}, "8888"));
    }

    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        if (deadends != null && deadends.length > 0) {
            visited.addAll(Arrays.asList(deadends));
        }
        String top = "0000";
        if (visited.contains(top)) {
            return -1;
        }
        queue.add(top);

        int step = 0;
        String plus;
        String minus;
        int levelSize = 1;
        visited.add(top);
        while (!queue.isEmpty()) {
            for (int j = 0; j < levelSize; j++) {
                top = queue.poll();
                if (top.equals(target)) {
                    return step;
                }
                for (int i = 0; i < 4; i++) {
                    plus = plus(top, i);
                    if (!visited.contains(plus)) {
                        visited.add(plus);
                        queue.offer(plus);
                    }
                    minus = minus(top, i);
                    if (!visited.contains(minus)) {
                        visited.add(minus);
                        queue.offer(minus);
                    }
                }
            }
            levelSize = queue.size();
            step++;
        }
        return -1;
    }


    private String plus(String src, int index) {
        char[] chars = src.toCharArray();
        char c = chars[index];
        if (c == '9') {
            c = '0';
        } else {
            c = (char) (c + 1);
        }
        chars[index] = c;
        return new String(chars);
    }

    private String minus(String src, int index) {
        char[] chars = src.toCharArray();
        char c = chars[index];
        if (c == '0') {
            c = '9';
        } else {
            c = (char) (c - 1);
        }
        chars[index] = c;
        return new String(chars);
    }


}
