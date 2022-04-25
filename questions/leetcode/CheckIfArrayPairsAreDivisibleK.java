package questions.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class CheckIfArrayPairsAreDivisibleK {

    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer,ArrayList> integerHashMap = new HashMap<>();

        for (int i = 0 ; i<arr.length ; i++){
           integerHashMap
                   .computeIfAbsent(arr[i] % 5,
                           j -> new ArrayList<Integer>()).add(arr[i]);
        }



        return true;
    }

}
