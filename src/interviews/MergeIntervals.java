package interviews;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][] {{1,3},{6,8},{9,10}};
        List<int[]> mergedIntervals = mergeIntervals(intervals);
        for (int[] interval: mergedIntervals) {
            System.out.println(interval[0] + " , " + interval[1]);
        }
    }

    private static List<int[]> mergeIntervals(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        int j = 1;
        for (int i = 1; i < intervals.length; i++) {
            int[] last = result.getLast();
            if (doesOverlap(last, intervals[i])) {
                result.set(result.size()-1, new int[] { last[0], Math.max(last[1], intervals[i][1])});
            } else {
                result.add(intervals[i]);
            }
        }
        return result;
    }

    private static boolean doesOverlap(int[] a, int[] b) {
        return (b[0] <= a[1]) && (b[1] >= a[0]);
    }
}
