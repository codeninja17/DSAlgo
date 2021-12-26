package questions.leetcode;

import java.util.Arrays;

/**
 * 167. Two Sum II - Input array is sorted
 */
public class TwoSum2 {

    public  static int[] twoSum(int [] numbers , int target){
        int[] result = new int[2];

        int left_pointer = 0;
        int right_pointer = numbers.length-1;

        while(left_pointer<right_pointer){
            int sum = numbers[left_pointer] + numbers[right_pointer];
            if(sum == target){
             result[0] = numbers[left_pointer];
             result[1] = numbers[right_pointer];
             return result;
            }
            else if(sum > target)
                right_pointer--;
            else
                left_pointer++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(Arrays.toString(twoSum(arr,7)));
    }

}
