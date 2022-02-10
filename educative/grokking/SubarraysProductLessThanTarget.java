package educative.grokking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubarraysProductLessThanTarget {

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> subarrays = new ArrayList<>();
        int leftPtr = 0;
        int rightPtr = 0;
        int prevPro = 1;
        while(rightPtr < arr.length && leftPtr<arr.length){
                prevPro = prevPro * arr[rightPtr];
                if(prevPro < target) {
                    List<Integer> tempList = new LinkedList<>();
                    for (int i = rightPtr; i >= leftPtr; i--) {
                        tempList.add(0, arr[i]);
                        subarrays.add(new ArrayList<>(tempList));
                    }
                    rightPtr++;
                }
                else{
                        prevPro = prevPro / (arr[leftPtr] * arr[rightPtr]);
                        leftPtr++;
                    }
                }
        return subarrays;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3};
        System.out.println(findSubarrays(arr,0));
    }
}
