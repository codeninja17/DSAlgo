package questions.leetcode;

public class SingleElementinaSortedArray {


    public static int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) return nums[0];
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if(mid == nums.length -1 && nums[mid - 1] != nums[mid]) return nums[mid];
            if(mid == 0 && nums[mid + 1] != nums[mid]) return nums[mid];
            if ((mid + 1) < nums.length && mid - 1 >= 0 && nums[mid + 1] != nums[mid] && nums[mid - 1] != nums[mid])
                return nums[mid];
            else if (mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
                if ((mid) % 2 == 0) {
                    end = mid - 1;
                } else start = mid + 1;
            } else if (mid + 1 < nums.length && nums[mid] == nums[mid + 1]) {
                if (((nums.length-1) - mid) % 2 == 1) {
                    end = mid - 1;
                } else start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1,1,2,2,3};
        System.out.println(singleNonDuplicate(arr));
    }
}

