package questions.leetcode;

/**
 * Kth Missing Positive Number
 */
public class KThMissingNumber {

    public int findKthPositive(int[] arr, int k) {
        return searchNum(arr,0,arr.length-1,k);
    }

    public static int searchNum(int [] arr , int start , int end , int k) {
        if(start >= end) {
            return start+k;
        }
        int mid = (start+end)/2;
        int diff = arr[mid]-(mid+1);
        if(diff >= k) {
            end = mid;
        }
        else start = mid+1;
        return searchNum(arr,start,end,k);
    }

    public static void main(String[] args) {
        int [] arr = {2,3,4,7,11};
        KThMissingNumber kThMissingNumber = new KThMissingNumber();
        System.out.println(kThMissingNumber.findKthPositive(arr,5));
    }
}

