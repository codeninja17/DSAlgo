package questions.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 57. Insert Interval
 */
public class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        int i = 0;
        List<int[]> mergedInterval = new ArrayList<>();
        while (i<intervals.length && intervals[i][1] < newInterval[0] ){
            mergedInterval.add(intervals[i]);
            i++;
        }

        while(i<intervals.length && newInterval[1] >= intervals[i][0]){
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            i++;
        }

        mergedInterval.add(newInterval);

        while (i < intervals.length){
            mergedInterval.add(intervals[i++]);
        }

        return mergedInterval.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int [] [] arr ={{1,3}, {6,9}, {10,12}};
        // System.out.println(Arrays.deepToString(insert(arr, new int[]{2, 5})));
        int [][] arr2 = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        System.out.println(Arrays.deepToString(insert(arr2, new int[]{4, 8})));

    }

}
