package questions.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    public static int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        Arrays.sort(intervals, (o1, o2) -> {
            if(o1[0] ==  o2[0]){
               return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        int i = 0 ;
        int j= 1;
        while(i < intervals.length && j <intervals.length){
            int end = intervals[i][1];
            j=i+1;
            while(j<intervals.length && end > intervals[j][0]){
                if(intervals[i][1] > intervals[j][1]){
                    end = intervals[j][1];
                    i = j;
                }
                j++;
                count++;
            }
            i = j;
        }
        return count;
    }

    public static void main(String[] args) {
        int [][] arr = {{-52,31},{-73,-26},{82,97},{-65,-11},{-62,-49},{95,99},{58,95},{-31,49},{66,98},{-63,2},{30,47},{-40,-26}};
        System.out.println(eraseOverlapIntervals(arr));
    }
}
