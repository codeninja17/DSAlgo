package questions.leetcode;

public class SearchRotatedArray2 {

    public boolean search(int[] nums, int target) {
        if(nums.length == 0){
            return false;
        }
        return searchNum(nums,target,0,nums.length-1);
    }

    public boolean searchNum(int [] nums, int target , int start , int end){
        if(start == end)
            return nums[start] == target;
        int mid = (start + end)/2;
        if(nums[mid] == target)
            return true;
        if(nums[start] < nums[mid]){
            if(target >= nums[start] && target < nums[mid] && mid > 0){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }else if(nums[start] == nums[mid]){
            if(target < nums[mid] && mid > 0){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        else{
            if(target > nums[mid] && target <=nums[end]){
                start = mid+1;
            } else if (mid >0){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return searchNum(nums,target,start,end);
    }

        public static void main(String[] args) {
            SearchRotatedArray2 searchRotatedArray2 = new SearchRotatedArray2();
            System.out.println(searchRotatedArray2.search(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1},2));
        }

}
