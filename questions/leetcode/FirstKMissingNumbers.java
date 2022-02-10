package questions.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FirstKMissingNumbers {

    public static List<Integer> findNumbers(int[] nums, int k) {
        List<Integer> missingNumbers = new ArrayList<>();

        int i = 0 ;
        while(i < nums.length){
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i]-1]){
                swap(nums,i,nums[i]-1);
            }
            else i++;
        }
        for(int j = 0; j < nums.length ;j++){
            if(nums[j] != j+1){
               missingNumbers.add(j+1);
               k--;
            }
        }
        int m = nums.length+1;
        while (k > 0) {
            missingNumbers.add(m++);
            k--;
        }

        return missingNumbers;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
