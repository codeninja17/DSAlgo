package datastructures;

import java.util.Arrays;

public class MinHeap {

    static void buildMinHeap(int [] arr){
        int n = arr.length;
        for (int i=n/2;i>=0;i--){
            heapify(arr,i,n);
        }
    }

    // recurse and build heap for each min heap
    static void heapify(int arr[],int root,int arrLength){
        int largest = root;
        int left_child = 2 * root + 1;
        int right_child = 2 * root + 2;

        if(left_child < arrLength && arr[left_child] < arr[largest]){
            largest = left_child;
        }

        if(right_child < arrLength && arr[right_child] < arr[largest]){
            largest = right_child;
        }

        if(largest != root){
            swap(arr,largest,root);
            heapify(arr,largest,arrLength);
        }
    }

    static void swap(int [] arr , int a , int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        buildMinHeap(arr);
        System.out.println(Arrays.toString(arr));
    }

}
