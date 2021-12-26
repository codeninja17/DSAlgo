package questions.leetcode;

/**
 * 153. Find Minimum in Rotated Sorted Array
 */
public class MinimumInRotatedArray {

    public int findMin(int[] nums){
        if(nums.length == 1)
            return nums[0];
        return findMinInRotatedArray(nums,0,nums.length-1);
    }

    public int findMinInRotatedArray(int [] nums , int start , int end){
        if(start == end)
            return nums[start];
        int mid = (start+end)/2;
        if((mid-1)>-1 && nums[mid] < nums[mid-1] && (mid+1)<nums.length && nums[mid+1] > nums[mid]){
            return nums[mid];
        }
        if(nums[mid] <= nums[start] && nums[mid] <= nums[end]){
            end = mid;
        }
        else if(nums[mid] >= nums[start]){
            if(nums[mid]>= nums[end]){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        else if(nums[mid] <= nums[end])
            start = mid+1;
        return findMinInRotatedArray(nums,start,end);
    }

    public static void main(String[] args) {
        int [] nums = {1,2,0};
        MinimumInRotatedArray minimumInRotatedArray = new MinimumInRotatedArray();
        System.out.println(minimumInRotatedArray.findMin(nums));
    }

}
