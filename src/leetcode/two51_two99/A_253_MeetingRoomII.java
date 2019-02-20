package leetcode.two51_two99;


import java.util.Arrays;
import java.util.Comparator;

class Interval {
    int start;
    int end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class A_253_MeetingRoomII {
    public static void main(String[] args) {
        Interval a = new Interval(9, 10);
        Interval b = new Interval(4, 9);
        Interval c = new Interval(4, 17);
        Interval[] intervals = {a, b, c};
        System.out.println(minMeetingRooms(intervals));
    }

    //til todo
    public static int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0) return 0;
        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval interval1, Interval interval2) {
                if (interval1.end == interval2.end) {
                    return interval1.start - interval2.start;
                }
                return interval1.end - interval2.end;
            }
        };
        Arrays.sort(intervals, comparator);
        int count = 1;
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i + 1].start < intervals[i].end) {
                count++;
            }
        }
        return count;
    }


}

/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
find the minimum number of conference rooms required.

Example 1:
Input: [[0, 30], [5, 10],[15, 20]]  // 2 conflict, 1 ko conflict
Output: 2

[5, 10], [15, 20], [0, 30]

Example 2:
Input: [[7,10],[2,4]]// no conflict -> 1
Output: 1

[2,4], [7,10]
 */
/*
0 conflict -> 1
1 conflict -> 2
2 conflict -> 2
 */

/*
//beat 5% O(n^2)
 public static int minMeetingRooms(Interval[] intervals) {
        int maxConflict = 0;
        int tmpCount;
        for (Interval x: intervals) {
            tmpCount = 0;
            for (Interval interval : intervals) {
                if (interval.start <= x.start && interval.end > x.start) {
                    tmpCount++;
                }
            }
            maxConflict = Math.max(maxConflict, tmpCount);
        }
        return maxConflict;
    }
 */