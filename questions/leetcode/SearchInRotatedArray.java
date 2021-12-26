package questions.leetcode;

/**
 * 33. Search in Rotated Sorted Array
 */
public class SearchInRotatedArray {

    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        return searchNum(nums,target,0,nums.length-1);
    }

    public int searchNum(int [] nums, int target , int start , int end){
        if(start == end)
            return nums[start] == target ? start : -1;
        int mid = (start + end)/2;
        if(nums[mid] == target)
            return mid;
        if(nums[start] <= nums[mid]){
            if(target >= nums[start] && target < nums[mid]){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }else{
            if(target > nums[mid] && target <=nums[end]){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        int index = searchNum(nums,target,start,end);
        return nums[index] == target ? index :-1;
    }

    public static void main(String[] args) {
        SearchInRotatedArray searchInRotatedArray = new SearchInRotatedArray();
        System.out.println(searchInRotatedArray.search(new int[]{2,5,6,0,0,1,2},6));
    }
}
