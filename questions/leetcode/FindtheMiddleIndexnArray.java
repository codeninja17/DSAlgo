package questions.leetcode;

import java.util.Arrays;

/**
 * 1991. Find the Middle Index in Array
 */
public class FindtheMiddleIndexnArray {

    public static int findMiddleIndex(int[] nums) {

        int [] forwardSum = new int[nums.length+2];
        int [] backwardSum = new int[nums.length+2];
        forwardSum[0] = 0;
        forwardSum[forwardSum.length-1] = 0;
        backwardSum[0] = 0;
        backwardSum[backwardSum.length-1] = 0;
        int fSum = 0;
        int bSum = 0;
        for (int i=0; i<nums.length;i++){
            fSum+=nums[i];
            forwardSum[i+1] = fSum;
        }

        for (int i=nums.length-1; i>=0;i--){
            bSum+=nums[i];
            backwardSum[i+1] = bSum;
        }


        System.out.println(Arrays.toString(forwardSum));
        System.out.println(Arrays.toString(backwardSum));

        for(int i = 1 ; i<forwardSum.length-1;i++){
            if(forwardSum[i-1] == backwardSum[i+1]){
                return i-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] nums = {2,3,-1,8,4};
        System.out.println(FindtheMiddleIndexnArray.findMiddleIndex(nums));
    }

}
