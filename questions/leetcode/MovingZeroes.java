package questions.leetcode;

import java.util.Arrays;

/**
 * 283. Move Zeroes
 */
public class MovingZeroes {

    public static void moveZeroes(int[] nums){
        int left_pointer = 0;
        int right_pointer = 0;
        while(right_pointer<nums.length){
            if(nums[right_pointer] == 0)
                right_pointer++;
            else{
                swap(nums,left_pointer++,right_pointer++);
            }
        }
    }

    private static void swap(int[] nums, int left_pointer, int right_pointer) {
        int temp = nums[right_pointer];
        nums[right_pointer] = nums[left_pointer];
        nums[left_pointer] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,0,0,12,0,8,3,0,6,8,0,};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

    }
}
