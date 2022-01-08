package algorithms.recursion;

import java.util.Arrays;

public class ArrayOps {

    public boolean isSorted(int [] arr , int startingIndex){
        if((startingIndex+1) == arr.length)
            return true;

        if(arr[startingIndex] > arr[startingIndex+1]){
            return false;
        }
        return isSorted(arr,startingIndex+1);
    }

    public int firstIndex(int [] arr, int  startingIndex , int data){
        if(startingIndex == arr.length){
            return -1;
        }
        if(arr[startingIndex] == data){
            return startingIndex;
        }else {
            return firstIndex(arr,startingIndex+1,data);
        }
    }

    // not allowed to start traversing from last index
    public int lastIndex(int [] arr , int startingIndex , int data){
        if(startingIndex == arr.length){
            return -1;
        }
        int index = lastIndex(arr,startingIndex+1,data);
        if(index == -1){
            if(arr[startingIndex] == data){
                return startingIndex;
            }
            else {
                return -1;
            }
        }
        else {
            return index;
        }
    }

    public int [] allIndices(int [] arr , int startingIndex , int data,int count){
        int [] indices = null;
        if(startingIndex == arr.length){
            indices = new int[count];
            return indices;
        }
        if(arr[startingIndex] ==  data)
             indices = allIndices(arr,startingIndex+1,data,count+1);
        else indices = allIndices(arr,startingIndex+1,data,count);

        if(arr[startingIndex] == data){
            indices[count] = startingIndex;
        }
        return indices;
    }

    public static void main(String[] args) {
      ArrayOps arrayOps = new ArrayOps();
      int [] arr = {1,2,12,3,4,12,5,6,12,2,2,2,2,2,2,2};
        System.out.println(arrayOps.isSorted(arr,0));
        System.out.println(arrayOps.firstIndex(arr,0,12));
        System.out.println(arrayOps.lastIndex(arr,0,12));
        System.out.println(Arrays.toString(arrayOps.allIndices(arr,0,2,0)));
    }
}
