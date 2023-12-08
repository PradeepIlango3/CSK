package interviews;

import java.util.Stack;

public class StockSpan {

    public static void main(String[] args) {
       //int[] input = {100, 80, 60, 70, 60, 75, 85};
       //int[] input = {100, 80, 60, 30, 29, 15, 5};
       int[] input = {5, 15, 29, 30, 60, 80, 100};
       int[] span = findStockSpan(input);
       for (int s: span) {
           System.out.println(s);
       }
    }

    private static int[] findStockSpan(int[] input) {
        if (input.length == 0) throw new IllegalArgumentException("Input is length zero");
        int[] span = new int[input.length];
        Stack<Integer> spans = new Stack<>();
        for (int i = 0; i < input.length; i++) {
            while (!spans.isEmpty() && input[spans.peek()] <= input[i]) {
                spans.pop();
            }
            if (spans.isEmpty()) {
                span[i] = i+1;
            } else {
                span[i] = i - spans.peek();
            }
            spans.push(i);
        }
        return span;
    }
}
