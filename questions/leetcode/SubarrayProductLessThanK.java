package questions.leetcode;

public class SubarrayProductLessThanK {


    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int leftPtr = 0;
        int rightPtr = 0;
        double prevPro = 1;
        int maxSubArrays = 0;
        while(rightPtr < nums.length && leftPtr<nums.length){
            if(prevPro*nums[rightPtr] < k) {
                prevPro= prevPro*nums[rightPtr];
                maxSubArrays+=rightPtr-leftPtr+1;
            }
            else{
                while(prevPro*nums[rightPtr] >= k && leftPtr<=rightPtr){
                    prevPro = Math.ceil(prevPro / nums[leftPtr]);
                    leftPtr++;
                }
                if(prevPro*nums[rightPtr] < k) {
                    prevPro= prevPro*nums[rightPtr];
                    maxSubArrays+=rightPtr-leftPtr+1;
                }
            }
            rightPtr++;
        }
        return maxSubArrays;
    }

    public static void main(String[] args) {
        int [] arr = {57,44,92,28,66,60,37,33,52,38,29,76,8,75,22};
        System.out.println(numSubarrayProductLessThanK(arr,18));
    }

}
