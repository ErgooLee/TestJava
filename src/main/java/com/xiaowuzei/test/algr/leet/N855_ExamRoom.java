package com.xiaowuzei.test.algr.leet;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class N855_ExamRoom {
    public static void main(String[] args) {
        ExamRoom examRoom = new ExamRoom(4);
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        examRoom.leave(1);
        examRoom.leave(3);
        System.out.println(examRoom.seat());

    }

}

class ExamRoom {

    private int N;
    private TreeSet<int[]> intervals;
    private Map<Integer, int[]> starts;
    private Map<Integer, int[]> ends;

    public ExamRoom(int N) {
        this.N = N;
        intervals = new TreeSet<>((o1, o2) -> {
            int length1 = length(o1[0], o1[1]);
            int length2 = length(o2[0], o2[1]);
            if (length1 == length2) {
                return Integer.compare(o1[0], o2[0]);
            } else {
                return Integer.compare(length2, length1);
            }
        });
        int[] node = new int[]{-1, N};
        intervals.add(node);
        starts = new HashMap<>();
        starts.put(-1, node);
        ends = new HashMap<>();
        ends.put(N, node);
    }

    public int seat() {
        int[] longest = intervals.pollFirst();
        int seat;
        if (longest[0] == -1) {
            seat = 0;
        } else if (longest[1] == N) {
            seat = N - 1;
        } else {
            seat = (longest[1] + longest[0]) / 2;
        }

        int[] node1 = {longest[0], seat};
        intervals.add(node1);

        int[] node2 = {seat, longest[1]};
        intervals.add(node2);

        starts.remove(longest[0]);
        starts.put(longest[0], node1);
        starts.put(seat, node2);

        ends.remove(longest[1]);
        ends.put(seat, node1);
        ends.put(longest[1], node2);
        return seat;
    }

    public void leave(int p) {
        int[] node1 = starts.remove(p);
        int[] node2 = ends.remove(p);
        intervals.remove(node1);
        intervals.remove(node2);
        int[] node3 = {node2[0], node1[1]};
        intervals.add(node3);
        starts.put(node2[0], node3);
        ends.put(node1[1], node3);
    }

    private int length(int start, int end) {
        if (start == -1) {
            return end;
        } else if (end == N) {
            return N - start - 1;
        } else {
            return (end - start) / 2;
        }
    }

}
