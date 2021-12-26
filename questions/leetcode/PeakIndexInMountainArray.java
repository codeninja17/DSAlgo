package questions.leetcode;

/**
 * LC 852. Peak Index in a Mountain Array
 */

public class PeakIndexInMountainArray {

    public static int hasPeakIndex(int[] arr,int low,int high){

        if(low == high || low > high){
            if(low != 0 && low!=arr.length-1) {
                if (arr[low] > arr[low - 1] && arr[low] > arr[low + 1]) {
                    return low;
                }
            }
            else{
                return -1;
            }

        }

        int mid = (low+high)/2;

        if(mid!=0 && mid!=arr.length && arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]){
            return mid;
        }
        if(mid!=arr.length && arr[mid] < arr[mid+1]){
            return hasPeakIndex(arr,mid+1,high);
        }
        else if(mid!=arr.length && arr[mid] > arr[mid+1]){
           return hasPeakIndex(arr,low,mid-1);
        }
        return -1;
    }

    public static void main(String[] args) {
        int []arr = {0,2,8,4,1};
        System.out.println(hasPeakIndex(arr,0,arr.length-1));
    }

}
