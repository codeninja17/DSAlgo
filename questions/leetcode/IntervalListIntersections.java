package questions.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 986. Interval List Intersections
 */
public class IntervalListIntersections {

    public  static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0;
        int j = 0;
        List<int[]> intervalIntersect = new ArrayList<>();
        while(i < firstList.length && j < secondList.length){

            if ((firstList[i][0] >= secondList[j][0] && firstList[i][0] <= secondList[j][1])
                    || (secondList[j][0] >= firstList[i][0] && secondList[j][0] <= firstList[i][1])) {
                int start = Math.max(firstList[i][0],secondList[j][0]);
                int end = Math.min(firstList[i][1],secondList[j][1]);
                intervalIntersect.add(new int[]{start,end});
            }

            if(firstList[i][1] <= secondList[j][1])  i++;
            else j++;
        }

        return intervalIntersect.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int [] [] arr ={{0,2},{5,10},{13,23},{24,25}};
        int [][] arr2 = {{1,5},{8,12},{15,24},{25,26}};
        System.out.println(Arrays.deepToString(intervalIntersection(arr,arr2)));
    }

}
