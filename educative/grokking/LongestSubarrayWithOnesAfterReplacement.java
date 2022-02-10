package educative.grokking;

/**
 * Longest Subarray with Ones after Replacement
 */
public class LongestSubarrayWithOnesAfterReplacement {

    public static int findLength(int[] arr, int k) {
       int maxOnesInWindow = 0;
       int windowStart = 0;
       int maxLen = 0;
       for(int i = 0; i<arr.length;i++){
           if(arr[i] == 1) {
               maxOnesInWindow++;
           }
           if(i - windowStart + 1 - maxOnesInWindow > k){
               if(arr[windowStart] == 1){
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
        System.out.println(findLength(arr,1));
    }

}
