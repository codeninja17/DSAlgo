package questions.GFG;

import java.util.Arrays;

public class MinimumAndMaximumOfAnArray {

    public static int [] findMaxAndMin(int [] arr,int low, int high, int [] maxAndMin){

        if(low == high || low > high){
            maxAndMin[0] = arr[low];
            maxAndMin[1] = arr[low];
            return maxAndMin;
        }
         else if(low == high-1){
             if(arr[low] >= arr[high]){
                 maxAndMin[0] = arr[low];
                 maxAndMin[1] = arr[high];
             }
             else{
                 maxAndMin[0] = arr[high];
                 maxAndMin[1] = arr[low];
             }
        }else{


             int mid = low + (high-low)/2;
             findMaxAndMin(arr,low,mid,maxAndMin);
             int [] maxMin_L = new int[2];
             maxMin_L[0] = maxAndMin[0];
             maxMin_L[1] =maxAndMin[1];
             findMaxAndMin(arr,mid+1,high,maxAndMin);
            int [] maxMin_R = new int[2];
            maxMin_R[0] = maxAndMin[0];
            maxMin_R[1] =maxAndMin[1];

            if(maxMin_R[0] > maxMin_L[0]){
                 maxAndMin[0] = maxMin_R[0];
             }
             else{
                 maxAndMin[0] = maxMin_L[0];
             }

            if(maxMin_R[1] < maxMin_L[1]){
                maxAndMin[1] = maxMin_R[1];
            }
            else{
                maxAndMin[1] = maxMin_L[1];
            }
        }
        return maxAndMin;
    }

    public static void main(String[] args) {
        int[] arr = {45, 43, 87, 90, 876, 543, 667, 9987, -12, 67, 0};
        int[] maxMin = new int[2];
        maxMin = findMaxAndMin(arr, 0, arr.length - 1, maxMin);
        System.out.println(Arrays.toString(maxMin));

        int[] arr_1 = {91, 78, 90, 89};
        maxMin = new int[2];
        maxMin = findMaxAndMin(arr_1, 0, arr_1.length - 1, maxMin);
        System.out.println(Arrays.toString(maxMin));
    }
}

