package Algorithms;

import java.util.Arrays;

public class MergeSort {

    public static void divide(int[] arr,int low,int high){

        if(low == high || low > high){
            return ;
        }

        int mid = low+(high-low)/2;

        System.out.println("Call From "+ low +" To " + mid);
        divide(arr,low,mid);
        System.out.println("Call From "+ (mid+1) +" To " + high);
        divide(arr,mid+1,high);
        merge(arr,low,mid,high);
        System.out.println(Arrays.toString(arr));
        return ;
    }

    public static void merge(int arr[],int low , int mid , int high){
        int firstArrLow = low;
        int firstArrHigh = mid;
        int secondArrLow = mid+1;
        int secondArrHigh = high;

        int firstArrLen = firstArrHigh-firstArrLow+1;
        int secondArrLen = secondArrHigh-secondArrLow+1;

        // create temp arrays
        int [] L = new int[firstArrLen];
        int [] R = new int[secondArrLen];

        int m =0 ,n = 0;
        for(int i = firstArrLow; i<=firstArrHigh;i++){
            L[m++] = arr[i];
        }

        for(int j = secondArrLow;j<=secondArrHigh;j++){
            R[n++] = arr[j];
        }

        int i = 0;
        int j = 0;
        int k=low;


        // compare two elements from sorted list
        while(i<firstArrLen && j<secondArrLen){
            if(L[i] > R[j] ){
                arr[k] = R[j];
                j++;
            }
            else{
                arr[k] = L[i];
                i++;
            }
            k++;
        }

        // copy the remaining elements
        while(i<firstArrLen){
            arr[k++] = L[i++];
        }

        while(j<secondArrLen){
            arr[k++] = R[j++];
        }

        // System.out.println(Arrays.toString(arr));

    }

    public static void main(String[] args) {
        int [] arr = {3,6,1,9,5,2};
        divide(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
}
