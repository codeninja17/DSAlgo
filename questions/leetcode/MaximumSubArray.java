package questions.leetcode;

/**
 * 53. Maximum Subarray
 */
public class MaximumSubArray     {

    public static int maxSum(int [] arr,int l,int h){
        if(l == h || l > h){
            return arr[l];
        }
        int mid = l + (h-l)/2;
        int leftSum = maxSum(arr,l,mid);
        int rightSum = maxSum(arr,mid+1,h);
        System.out.println(l + " " + mid + " "+h);
        return 1;
    }

    public static void main(String[] args) {
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        maxSum(arr,0,arr.length-1);
    }

}
