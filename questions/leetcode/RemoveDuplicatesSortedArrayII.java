package questions.leetcode;

/**
 * 80. Remove Duplicates from Sorted Array II
 */
public class RemoveDuplicatesSortedArrayII {

    public int removeDuplicates(int[] nums) {
        int j = 1;
        int cnt = 1;
        for(int i = 1; i<nums.length;i++){
            if(nums[i] == nums[j-1] && cnt < 2){
                nums[j] = nums[i];
                cnt++;
                j++;
            }
            else if(nums[i]!=nums[j-1]){
                nums[j] = nums[i];
                cnt = 1;
                j++;
            }
        }
        return j;
    }

}
