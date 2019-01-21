package leetcode.two51_two99;


import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
    // max queue is always larger than 1 or equal to min queue
    PriorityQueue<Integer> min = new PriorityQueue();
    PriorityQueue<Integer> max = new PriorityQueue(Collections.reverseOrder());

    // Adds a number into the data structure.
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if (max.size() < min.size()) {
            max.offer(min.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (max.size() == min.size()) return (max.peek() + min.peek()) / 2.0;
        else return max.peek();
    }

}

public class A_295_FindMedianFromDataStream {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(10);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
//        medianFinder.addNum(5);
//        System.out.println(medianFinder.findMedian());
//        medianFinder.addNum(0);
//        System.out.println(medianFinder.findMedian());
//        medianFinder.addNum(6);
//        System.out.println(medianFinder.findMedian());
//        medianFinder.addNum(3);
//        System.out.println(medianFinder.findMedian());
//        medianFinder.addNum(1);
//        System.out.println(medianFinder.findMedian());
//        medianFinder.addNum(0);
//        System.out.println(medianFinder.findMedian());
//        medianFinder.addNum(0);
//        System.out.println(medianFinder.findMedian());
    }

}

/*
tree min store large value
tree max store small value
size of tree max is always larger than 1 or equal to tree min
 */
