package questions.leetcode;

/**
 * Shortest Unsorted Continuous Subarray
 */
public class ShortestUnsortedContinuousSubarray {

    public static int findUnsortedSubarray(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        while(low < nums.length-1 && nums[low] <= nums[low+1]){
            low++;
        }

        if(low == nums.length-1){
            return 0;
        }

        while(high > 0 && nums[high-1] <= nums[high]){
            high--;
        }

        int minInSub = Integer.MAX_VALUE;
        int maxInSub = Integer.MIN_VALUE;

        for(int i = low ; i<=high ; i++){
            maxInSub = Math.max(maxInSub,nums[i]);
            minInSub = Math.min(minInSub,nums[i]);
        }

        while(low > 0 && nums[low-1] > minInSub){
            low--;
        }

        while (high < nums.length-1 && nums[high+1] < maxInSub){
            high++;
        }

        return high-low+1;
    }

    public static void main(String[] args) {
        System.out.println(ShortestUnsortedContinuousSubarray.findUnsortedSubarray(new int[] { 1, 2, 5, 3, 7, 10, 9, 12 }));
        System.out.println(ShortestUnsortedContinuousSubarray.findUnsortedSubarray(new int[] { 1, 3, 2, 0, -1, 7, 10 }));
        System.out.println(ShortestUnsortedContinuousSubarray.findUnsortedSubarray(new int[] { 1, 2, 3 }));
        System.out.println(ShortestUnsortedContinuousSubarray.findUnsortedSubarray(new int[] { 3, 2, 1 }));
    }

}
