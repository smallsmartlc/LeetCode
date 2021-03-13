package Leetcode.smart;


import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * leetcode 252. 会议室 II
 * lintcode 919. 会议室 II
 */
public class work0253 {

    public static void main(String[] args) {

        work0253 w = new work0253();
    }

    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        intervals.sort(Comparator.comparingInt(a -> a.start));
        PriorityQueue<Integer> heap = new PriorityQueue<>(intervals.size(), Comparator.comparingInt(a -> a));
        heap.add(intervals.get(0).end);
        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (heap.peek() < interval.start) {
                heap.poll();
            }
            heap.add(interval.end);
        }
        return heap.size();
    }

    private static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}

