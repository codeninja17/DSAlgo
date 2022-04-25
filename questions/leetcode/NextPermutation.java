package questions.leetcode;

import java.util.Arrays;

/**
 * 31. Next Permutation
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if(nums.length == 1) return;
        int fp = nums.length-2;
        int sp = nums.length-1;
        int lp = nums.length-1;

        while(fp >= 0){
            if(nums[fp] >= nums[sp]){
                fp--;
                sp--;
            }else{
                reverseArr(nums,sp,lp);
                break;
            }
        }
        if(fp>=0){
            for(int i=sp;i<=lp;i++){
                if(nums[fp] < nums[i]){
                    int temp = nums[fp];
                    nums[fp] = nums[i];
                    nums[i] = temp;
                    break;
                }
            }
        }else {
            reverseArr(nums,0,nums.length-1);
        }
    }

    void reverseArr(int [] nums , int start , int end){
        while(start<=end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int [] nums = {5,1,1};
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

}
