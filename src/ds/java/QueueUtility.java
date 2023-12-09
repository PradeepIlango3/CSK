package ds.java;

import java.util.LinkedList;
import java.util.Queue;
public class QueueUtility {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(5);
        q.offer(10);
        System.out.println(q.peek());
        System.out.println(q.size());
        System.out.println(q.isEmpty());
        System.out.println(q.poll());
        System.out.println(q.peek());
    }
}
