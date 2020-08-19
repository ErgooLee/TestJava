package com.xiaowuzei.test.algr.leet;

import java.util.ArrayList;
import java.util.List;

public class N401_BinaryWatch {
    public static void main(String[] args) {
        System.out.println(new N401_BinaryWatch().readBinaryWatch(0));
    }

    public List<String> readBinaryWatch(int num) {
        this.num = num;
        array = new byte[num];
        selectN((byte) 0, (byte) 0);
        int hour;
        int minute;
        List<String> result = new ArrayList<>();
        for (byte[] selection : selections) {
            hour = 0;
            minute = 0;
            for (byte b : selection) {
                if (b <= 3) {
                    hour += 1 << (3 - b);
                } else {
                    minute += 1 << (9 - b);
                }
            }
            if (minute > 59 || hour > 11) {
                continue;
            }
            result.add(parseWatch(hour, minute));
        }
        return result;
    }

    int num;

    List<byte[]> selections = new ArrayList<>();

    byte[] array;

    public void selectN(byte index, byte selection) {
        if (index == num) {
            byte[] bytes = new byte[num];
            System.arraycopy(array, 0, bytes, 0, array.length);
            selections.add(bytes);
            return;
        }
        for (byte i = selection; i <= 10 + index - num; i++) {
            array[index] = i;
            selectN((byte) (index + 1), (byte) (i + 1));
        }
    }

    public List<String> readBinaryWatch2(int num) {
        List<String> times = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == num)
                    times.add(parseWatch(h, m));
            }
        }
        return times;
    }

    private String parseWatch(int hour, int minute) {
        StringBuilder sb = new StringBuilder();
        sb.append(hour).append(":");
        if (minute < 10) {
            sb.append(0);
        }
        sb.append(minute);
        return sb.toString();
    }


}
