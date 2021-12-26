package Algorithms;

import java.util.Arrays;

public class QuickSort {

    public static int partition(int [] arr , int p , int q){
        int pivot = arr[p];
        int i = p;
        for(int j = p+1;j<=q;j++){
            if(arr[j] >= pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i,p);
        return i;
    }

    public static void swap(int[] arr,int i , int j){
        int tempVar = arr[i];
        arr[i] = arr[j];
        arr[j]=tempVar;
    }

    public static int quickSort(int [] arr , int p , int q){
        if(p >= q){
            return 1;
        }
        int pivot = partition(arr,p,q);
        quickSort(arr,p,pivot-1);
        quickSort(arr,pivot+1,q);
        return 1;
    }

    public static void main(String[] args) {
        int [] nums ={3,2,3,1,2,4,5,5,6};
        quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

}
