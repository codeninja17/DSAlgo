package TUF;

public class MinInRotatedArray {

    public static int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        int left = 0 ;
        int right = nums.length -1 ;

        while(left < right) {
            int mid = left + (right-left)/2;

            if(nums[mid] < nums[(mid+1) % nums.length]
                    && nums[mid] < nums[Math.floorMod(mid-1, nums.length)]) {
                return nums[mid];
            }
            if(nums[left] <= nums[mid]) {
                if(nums[left] > nums[right]) left = mid +  1;
                else right = mid -1;
            }else {
                right = mid - 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int [] arr = {4,5,6,7,2};
        System.out.println(findMin(arr));
        // System.out.println(Math.floorMod(4,5));
    }
}
