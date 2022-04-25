package questions.leetcode;

import java.util.Arrays;

public class RotateArray {

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverseArray(0,nums.length-1,nums);
        reverseArray(0,k-1,nums);
        reverseArray(k,nums.length-1,nums);

    }

    public static void reverseArray(int start,int end,int [] arr){
        while(start<=end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int [] arr ={1,2,3,4,5,6,7};
        rotate(arr,3);
        System.out.println(Arrays.toString(arr));
    }

}
