package educative.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * arr[][] = [{1, 2}, {3, 4}, {5, 9}, {4, 3}, {9, 5}]
 * "{3,4}{5,9}"
 * Find symmetric pairs in an Array
 */
public class ArraySymmetricPair {

    static String arraySymmetricPair(int [][] arr){
        String res =  "";
        Map<Integer,int[]> arrMap = new HashMap<>();
        for (int i = 0 ; i<arr.length;i++){
            int [] pair = arr[i];
            if(arrMap.containsKey(pair[1])){
                int [] arr_p = arrMap.get(pair[1]);
                if(arr_p[1] == pair[0])
                    res += "{"+arr_p[0]+","+arr_p[1]+"} ";
            }
            arrMap.put(pair[0],pair);
        }
        return res;
    }

    public static void main(String[] args) {
        int [] [] arr= {{1, 2}, {3, 4}, {5, 9}, {4, 3}, {9, 5}};
        System.out.println(arraySymmetricPair(arr));

    }

}
