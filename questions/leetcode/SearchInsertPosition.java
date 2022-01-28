package questions.leetcode;

/**
 * 35. Search Insert Position
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int l = 0 , h = nums.length;
        int index = -1;
        while (l < h){
            int mid = (l+h)/2;

            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) h = mid;
            else l = mid+1;
        }
        if(l >= nums.length) return l;
        if(nums[l] > target){
            return l;
        }
        return l+1;
    }

    public static void main(String[] args) {
        int [] arr = {1,3,5,6};
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        System.out.println(searchInsertPosition.searchInsert(arr,4));
    }

}
