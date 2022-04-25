package questions.leetcode;

public class LongestMountaininArray {


    public static int longestMountain(int[] arr) {
        if(arr.length < 3) return 0;
        int maxLength = 0;
        int low = 0;
        int high = 0;
        while(low < arr.length && high < arr.length-1){
            int lowerSum = 0;
            int higherSum = 0;

            while(high < arr.length-1 && arr[high] == arr[high+1]){
                high++;
            }
            while(high < arr.length-1 && arr[high] < arr[high+1]) {
                lowerSum++;
                high++;
            }
            while (high < arr.length-1 && arr[high] > arr[high+1]){
                higherSum++;
                high++;
            }
            if(lowerSum > 0 && higherSum > 0 && lowerSum+higherSum >=2 && lowerSum+higherSum>=maxLength ){
                maxLength = lowerSum+higherSum+1;
            }
            lowerSum = 0;
            higherSum=0;
            low = high;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int []  arr = {875,884,239,731,723,685};
        System.out.println(longestMountain(arr));
    }

}
