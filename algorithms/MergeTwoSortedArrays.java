package algorithms;

import java.util.Arrays;

public class MergeTwoSortedArrays {

    public static int[] merge(int [] a , int [] b){

        int m = a.length;
        int n = b.length;

        int [] res = new int[m+n];

        int i = 0;
        int j = 0;
        int k = 0;

        while(i<m && j<n){
            if(a[i] > b[j]){
                res[k++] = b[j];
                j++;
            }
            else{
                res[k++] = a[i];
                i++;
            }
        }

        while(i<m){
            res[k++] = a[i++];
        }
        while(j<n){
            res[k++] = b[j++];
        }

        return res;

    }

    public static void main(String[] args) {
        int [] a = {7,8,9,10};
        int [] b = {5,6,7};
        System.out.println(Arrays.toString(merge(a,b)));

    }
}
