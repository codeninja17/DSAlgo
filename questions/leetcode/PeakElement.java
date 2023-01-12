package questions.leetcode;

public class PeakElement {

    public static int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        return peakElement(nums, 0, nums.length-1);
    }

    public static int peakElement(int[] nums, int start, int end) {
        if(start > end) return - 1;

        int mid = start + (end-start)/2;

        if((mid > 0 && mid < nums.length -1
                && nums[mid] > nums[mid-1]
                && nums[mid] > nums[mid+1])
                || (mid == nums.length-1 && nums[mid] > nums[mid-1])
                || (mid == 0 && nums[mid] > nums[mid+1])) {
            return mid;
        }
        int leftIndex = peakElement(nums, start, mid-1);
        int rightIndex = peakElement(nums, mid+1, end);

        return Math.max(leftIndex, rightIndex);
    }

    public static void main(String[] args) {
        int [] arr = {2,1};
        System.out.println(findPeakElement(arr));
    }
}
