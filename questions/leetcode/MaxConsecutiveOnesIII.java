package questions.leetcode;

/**
 * 1004. Max Consecutive Ones III
 */
public class MaxConsecutiveOnesIII {

    public static int longestOnes(int[] nums, int k) {
        int maxOnesInWindow = 0;
        int windowStart = 0;
        int maxLen = 0;
        for(int i = 0; i<nums.length;i++){
            if(nums[i] == 1) {
                maxOnesInWindow++;
            }
            if(i - windowStart + 1 - maxOnesInWindow > k){
                if(nums[windowStart] == 1){
                    maxOnesInWindow--;
                }
                windowStart++;
            }
            maxLen = Math.max(maxLen,(i-windowStart+1));
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int [] arr = {0};
        System.out.println(longestOnes(arr,1));
    }

}
