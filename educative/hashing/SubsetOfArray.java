package educative.hashing;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Find whether an array is a subset of another array
 * arr1 = [9,4,7,1,-2,6,5]
 * arr2 = [7,1,-2,5]
 * true
 */
public class SubsetOfArray {

    static boolean checkSubset(int [] arr1, int [] arr2){
        Map<Integer,Integer> arrMap = new HashMap<>();
        Arrays.stream(arr1).forEach(value -> arrMap.put(value,value));
        return Arrays.stream(arr2).allMatch(arrMap::containsKey);

    }

    public static void main(String[] args) {
        int [] arr1 = {9,4,7,1,-2,6,5};
        int [] arr2 ={7,1,-2,5,67};
        System.out.println(checkSubset(arr1,arr2));
    }

}
