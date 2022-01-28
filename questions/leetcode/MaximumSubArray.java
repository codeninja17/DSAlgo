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

        int leftSum = 0; int maxLeftSum = Integer.MIN_VALUE;
        for(int i = mid;i >= l;i--){
            leftSum += arr[i];
            if(leftSum > maxLeftSum){
                maxLeftSum = leftSum;
            }
        }

        int rightSum = 0 ; int maxRightSum = Integer.MIN_VALUE;
        for (int j = mid+1;j<=h;j++){
            rightSum += arr[j];
            if(rightSum > maxRightSum){
                maxRightSum = rightSum;
            }
        }
        int maxRightLeft = Math.max( maxSum(arr,l,mid) ,  maxSum(arr,mid+1,h));
        int max = Math.max(maxRightLeft , maxLeftSum + maxRightSum);
        System.out.println("Max for start :" + l + " and end : " + h + " is " + max);
        return max;
    }

    public static void main(String[] args) {
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSum(arr,0,arr.length-1));
    }

}
