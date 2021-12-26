package educative.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * arr1 = [9,4,3,1,-2,6,5]
 * arr2 = [7,10,8]
 * true
 * arr1 and arr2 have no common elements, so both of them are disjoint arrays.
 */

public class DisjointArrays {

    static boolean checkDisjointArrays(int[] arr1,int [] arr2){
        Map<Integer,Integer> arrMap = new HashMap<>();
        Arrays.stream(arr1).forEach(value -> arrMap.put(value,value));
        return Arrays.stream(arr2).noneMatch(arrMap::containsKey);
    }

    public static void main(String[] args) {
        int [] arr1 = {9,4,7,1,-2,6,5};
        int [] arr2 ={13,10,67};
        System.out.println(checkDisjointArrays(arr1,arr2));
    }


}
