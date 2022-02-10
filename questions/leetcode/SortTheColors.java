package questions.leetcode;

import java.util.Arrays;

/**
 * 75. Sort Colors
 */
public class SortTheColors {

    public static void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int i = 0;
        while(low<=high && i < nums.length){
            if(nums[i] == 0){
                swap(nums,low,i);
                low++;
                i++;
            }else if(nums[i] == 2 && high >= i){
                swap(nums,high,i);
                high--;
            }else {
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    static void swap(int [] nums , int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int [] arr ={2,0,2,1,1,0};
        sortColors(arr);
    }

}
