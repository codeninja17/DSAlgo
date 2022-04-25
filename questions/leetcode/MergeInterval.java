package questions.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. Merge Intervals
 */
public class MergeInterval {

    public static int[][] merge(int[][] intervals) {

        List<List<Integer>> resultSet = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i=1;i<intervals.length;i++){
            int[] currInterval = intervals[i];
            if(currInterval[0] <= end){
                end = Math.max(end,currInterval[1]);
            }else{
                resultSet.add(List.of(start,end));
                start = currInterval[0];
                end = currInterval[1];
            }
        }
        resultSet.add(List.of(start,end));

        return resultSet.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }

    public static void main(String[] args) {
        int [] []  arr = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(arr)));
    }

}
