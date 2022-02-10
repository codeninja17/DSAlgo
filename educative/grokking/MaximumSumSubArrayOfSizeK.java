package educative.grokking;

public class MaximumSumSubArrayOfSizeK {

    public static int findMaxSumSubArray(int k, int[] arr) {
        int sum = 0;
        int maxSum = 0;
        int windowStart = 0;
        int count = 0;
        for(int i = 0;i<arr.length;i++){
            sum = sum+arr[i];
            count++;
            if(count == k){
                count = count-1;
                if(sum > maxSum){
                    maxSum = sum;
                }
                sum = sum - arr[windowStart];
                windowStart+=1;
            }

        }
        return maxSum;
    }

    public static void main(String[] args) {
        int [] arr = {2, 3, 4, 1, 5};
        System.out.println(findMaxSumSubArray(2,arr));
    }

}
