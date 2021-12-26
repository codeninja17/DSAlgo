package questions.hackkerank;

import java.util.Arrays;

public class BreakingTheRecords {

    // Complete the breakingRecords function below.
    static int[] breakingRecords(int[] scores) {
        int max=0,min=0;
        if(scores.length >0){
             max=min=scores[0];
        }
        int maxBreakPoint = 0;
        int minBreakPoint = 0;
        for(int i = 1;i<scores.length;i++){
            if(scores[i] > max){
                max = scores[i];
                maxBreakPoint++;
            }
            else if(scores[i]<min){
                min = scores[i];
                minBreakPoint++;
            }

        }
        int[] result = new int[2];
        result[0] = maxBreakPoint;
        result[1]= minBreakPoint;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(breakingRecords(new int[]{10, 5 ,20, 20, 4, 5, 2, 25, 1})));
    }
}
