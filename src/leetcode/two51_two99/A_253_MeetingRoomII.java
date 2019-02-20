package leetcode.two51_two99;


class Interval{
    int start;
    int end;

    public Interval(){
        start = 0;
        end = 0;
    }

    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
}
public class A_253_MeetingRoomII {
    public static  void main(String[] args){

    }

    public static  int minMeetingRooms(Interval[] intervals) {
        return 0;
    }


}

/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
find the minimum number of conference rooms required.

Example 1:
Input: [[0, 30],[5, 10],[15, 20]]  // 2 conflict, 1 ko conflict
Output: 2

Example 2:
Input: [[7,10],[2,4]]// no conflict -> 1
Output: 1
 */
/*
0 conflic -> 1
1 conflict -> 2
2 conflict ->
 */