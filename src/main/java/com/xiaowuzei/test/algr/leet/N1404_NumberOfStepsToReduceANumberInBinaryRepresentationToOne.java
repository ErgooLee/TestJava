package com.xiaowuzei.test.algr.leet;

public class N1404_NumberOfStepsToReduceANumberInBinaryRepresentationToOne {
    public static void main(String[] args) {
        System.out.println(new N1404_NumberOfStepsToReduceANumberInBinaryRepresentationToOne().numSteps("10"));
    }

    public int numSteps(String s) {
        char[] chars = new char[s.length() + 1];
        System.arraycopy(s.toCharArray(), 0, chars, 1, s.length());
        int count = 0;
        int index = chars.length - 1;
        int lastIndex;
        chars[0] = '0';
        while (index >= 1) {
            lastIndex = index;
            if (index == 1 && chars[index] == '1') {
                return count;
            }
            //发现1
            while(index >= 0 && chars[index] == '1') {
                chars[index] = '0';
                count++;
                index--;
            }
            if (lastIndex != index) { //发现1
                chars[index] = '1';
                count++;
            } else { //发现0
                while(index >= 0 && chars[index] == '0') {
                    count++;
                    index--;
                }
            }
        }
        return count;
    }
}
