package zzz.test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Deque<Integer> a = new ArrayDeque<>();
        a.push(1);
        a.push(2);
        a.push(4);
        a.push(3);

        System.out.println(a.poll());


        Queue<Integer> q = new LinkedList<>();
        q.add(5);
        q.add(6);
        q.add(7);
        System.out.println(q.peek());
    }
}
