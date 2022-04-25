package questions.leetcode;

import java.util.*;

/**
 * 658. Find K Closest Elements
 */
public class FindKClosestElements {

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int pos = findPos(arr,x);
        int i  = pos - 1;
        int j = pos + 1;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(arr[pos]);
        while (priorityQueue.size()!=k){
            if((i>=0 && j < arr.length && (Math.abs(arr[i]- x)<=Math.abs(arr[j] - x))) || j>=arr.length){
                priorityQueue.add(arr[i]);
                i--;
            }else {
                priorityQueue.add(arr[j]);
                j++;
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!priorityQueue.isEmpty()){
            res.add(priorityQueue.poll());
        }
        return res;
    }

    public static int findPos(int [] arr , int x){
        if(x <= arr[0]){
            return 0;
        }else if(x >= arr[arr.length-1]) return arr.length-1;
        else {
            int low = 0;
            int high = arr.length-1;
            while (low <= high){
                int mid = (low+high)/2;
                if(x == arr[mid]) return mid;
                else if((mid+1) < arr.length && x > arr[mid] && x < arr[mid+1]){
                    if(Math.abs(arr[mid] - x) < arr[mid+1] - x) return mid;
                    else if(Math.abs(arr[mid] - x) == arr[mid+1] - x) return mid;
                    else return mid+1;
                }
                else if((mid-1) >= 0 && x<arr[mid] && x>arr[mid-1]){
                    if(Math.abs(arr[mid-1] - x) < arr[mid] - x) return mid-1;
                    else if(Math.abs(arr[mid-1] - x) == arr[mid] - x) return mid-1;
                    else return mid;
                }
                else if(arr[mid] > x){
                    high = mid-1;
                }else {
                    low = mid+1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] arr = {43,44,45,56,57,58};
        System.out.println(findClosestElements(arr,2,55));

        arr = new int[]{1,2,3,4,5};
        System.out.println(findClosestElements(arr,4,3));

        arr = new int[]{1,2,3,4,5};
        System.out.println(findClosestElements(arr,4,-1));

        arr = new int[]{43, 44, 45, 56, 57, 58};
        System.out.println(findClosestElements(arr,4,55));

        arr = new int[]{43, 44, 45, 56, 57, 58};
        System.out.println(findClosestElements(arr,5,44));
    }

}
