package educative.Queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class FirstNegativeNumberOfSizeK {

    public static int[] getFirstElementOfSizeK(int[] arr , int k){
        int[] res = new int[arr.length-k+1];
        Queue<Integer> integerQueue = new ArrayDeque<>();
        int windowCount = 0;
        int j = 0;
        for(int i=0;i<arr.length;i++){
            while(!integerQueue.isEmpty() && integerQueue.peek()<=(i-k)){
                integerQueue.poll();
            }
            if(arr[i] < 0) integerQueue.add(i);
            windowCount++;
            if(windowCount == k){
                windowCount = windowCount-1;
                if(!integerQueue.isEmpty()){
                    res[j++] = arr[integerQueue.peek()];
                }else{
                    res[j++] = -1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int [] arr =  {1,4,-90,13,-8,-13,4,5,5};
        System.out.println(Arrays.toString(getFirstElementOfSizeK(arr,3)));
    }
}
