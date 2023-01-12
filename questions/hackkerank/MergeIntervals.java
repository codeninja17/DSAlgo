package questions.hackkerank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(ints -> ints[0]));
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            List<Integer> res = new ArrayList<>();
            int j = i;
            int maxEnd = intervals[i][1];
            while (j < intervals.length - 1 && maxEnd >= intervals[j + 1][0]) {
                j++;
                maxEnd = Math.max(maxEnd, intervals[j][1]);
            }
            res.add(intervals[i][0]);
            res.add(maxEnd);
            i = j;
            result.add(res);
        }
        return result.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }

    public static void main(String[] args) {
        int[][] arr = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        System.out.println(Arrays.deepToString(merge(arr)));
    }

}
