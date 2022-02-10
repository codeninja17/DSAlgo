package educative.grokking;

public class SmallestSubarrayWithGreaterSum {

    public static int findMinSubArray(int S, int[] arr) {
        // TODO: Write your code here
        int minSubArraySize = Integer.MAX_VALUE;
        int windowStart = 0;
        int currWindowSize = 0;
        int sum = 0;
        for(int i = 0;i<arr.length;i++){
            sum = sum+arr[i];
            while(sum >= S){
                currWindowSize = i - windowStart+1;
                if(currWindowSize < minSubArraySize){
                    minSubArraySize = currWindowSize;
                }
                sum = sum - arr[windowStart];
                windowStart++;
            }

        }
        return minSubArraySize;
    }

    public static void main(String[] args) {
        int [] arr = {3, 4, 1, 1, 6};
        System.out.println(findMinSubArray(8,arr));
    }
}
