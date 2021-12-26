package questions.leetcode;

import java.util.*;

/**
 * 1. Two Sum
 */
public class TwoSum {

    public static int[] twoSum(int[]arr,int number){
       int [] sol = new int[2];

        Map<Integer, Integer> differenceMap = new HashMap<>();
        for(int i = 0; i<arr.length;i++){
            int diff = number - arr[i];
            if(differenceMap.containsKey(arr[i])){
                sol[0] = i;
                sol[1] = differenceMap.get(arr[i]);
                if(sol[0]!=sol[1])
                    break;
            }
            differenceMap.put(diff,i);
        }
        return sol;
    }

    public static void main(String[] args) {
        int [] arr = {3,2,4};
        System.out.println(Arrays.toString(twoSum(arr,6)));
    }

}
