package ds.java;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HeapUtility {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Arrays.asList(2, 9));
        pq.offer(3);
        pq.offer(10);
        pq.offer(-1);
        System.out.println(pq.size());
        System.out.println(pq.isEmpty());
        System.out.println(pq.peek());
        System.out.println(pq.poll());
    }
}
