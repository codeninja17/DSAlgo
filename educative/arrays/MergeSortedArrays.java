package educative.arrays;

import java.util.Arrays;

public class MergeSortedArrays {

    static int[] merge(int [] arr_1 , int [] arr_2){
        int m = arr_1.length;
        int n = arr_2.length;

        int i = 0;
        int j = 0;
        int k = 0;

        int []  result = new int[m+n];

        while(i<m && j<n){
            if(arr_1[i]<arr_2[j]){
                result[k++] = arr_1[i++];
            }
            else if(arr_1[i]>arr_2[j]){
                result[k++] = arr_2[j++];
            }
        }

        while(i<m){
            result[k++] = arr_1[i++];
        }
        while(j<n){
            result[k++] = arr_2[j++];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr_1 = {1,4,5,6,11,13};
        int[] arr_2 = {10,14,21,22,23};
        int [] result = merge(arr_1,arr_2);
        System.out.println(Arrays.toString(result));
    }

}
