package questions.leetcode;

import java.util.Arrays;

/**
 * 905. Sort Array By Parity
 */
public class SortArrayByParity {

    public static int[] sortArrayByParity(int[] nums) {
        int i = 0 ;
        int j = nums.length/2;
        for(int k = 0; k < nums.length;k++){
            if(nums[k] % 2 == 0 && i <nums.length && i<=k){
                swap(nums,i,k);
                i++;
            }
            else if(nums[k] % 2 != 0 && k<=j) {
                while (j < nums.length && nums[j] % 2 !=0){
                    j++;
                }
                if(j < nums.length){
                    swap(nums,j,k);
                    j++;
                }
            }
        }
        return nums;
    }

    private static void swap(int [] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int [] arr = {1};
        System.out.println(Arrays.toString(sortArrayByParity(arr)));
   }
}
