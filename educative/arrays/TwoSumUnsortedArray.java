package educative.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumUnsortedArray {

    static int[] findPair(int [] arr,int requiredSum){
        int result [] = new int[2];
        Map<Integer,Integer> integerMap = new HashMap<>();
        for(int val : arr){
            int difference =  requiredSum - val;
            if(integerMap.containsKey(difference)){
                result[0] = integerMap.get(difference);
                result[1] = val;
            }else{
                integerMap.put(val, val);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int [] arr = {1,21,3,14,5,60,7,6};
        System.out.println(Arrays.toString(findPair(arr,13)));
    }

}
