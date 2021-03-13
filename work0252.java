package Leetcode.smart;


import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * leetcode 252. 会议室
 * lintcode 920. 会议室
 */
public class work0252 {

    public static void main(String[] args) {

        work0252 w = new work0252();
    }

    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        intervals.sort(Comparator.comparingInt(a -> a.start));
        for (int i = 0; i < intervals.size()-1; i++) {
            Interval cur = intervals.get(i);
            Interval next = intervals.get(i+1);
            if(next.start - cur.end < 0){
                return false;
            }
        }
        return true;
    }
    private static class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}

