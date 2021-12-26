package questions.leetcode;

/**
 * 162. Find Peak Element
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        if(nums.length == 0)
            return -1;
        if(nums.length == 1)
            return 0;
        if (nums.length == 2) {
            return nums[0]<nums[1]? 1:0;
        }
        return findPeak(nums,0,nums.length-1);
    }

    public int findPeak(int[] nums , int start , int end){
        if(start >= end){
            if((start+1 < nums.length && nums[start+1] < nums[start]) && (start-1 > -1 && nums[start-1] < nums[start])){
                return start;
            }
            else if((start == 0 && nums[start+1] < nums[start]) || start == nums.length-1 && nums[start-1] < nums[start]){
                return start;
            }
            else
                return -1;
        }

        int mid = (start+end)/2;
        if((mid+1)< nums.length && nums[mid+1] < nums[mid] && (mid-1)>-1 && nums[mid-1] < nums[mid]
                || (mid == 0 && (nums[mid+1] < nums[mid])) || (mid == nums.length-1 && (nums[mid-1] < nums[mid]))){
               return mid;
        }
        else{
            int peak1 = findPeak(nums,start,mid-1);
            if(peak1!=-1){
                return peak1;
            }
            int peak2 = findPeak(nums,mid+1,end);
            if(peak2!=-1){
                return peak2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindPeakElement findPeakElement = new FindPeakElement();
        System.out.println(findPeakElement.findPeakElement(new int[]{5,4,3,4,5}));
    }

}
