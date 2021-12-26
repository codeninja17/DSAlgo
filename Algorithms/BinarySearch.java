package Algorithms;

public class BinarySearch {

    public int binarySearch(int [] arr,int low, int high,int numberToFind){

        //base case
        if(low == high || low > high){
            if(arr[low] == numberToFind){
                return low;
            }
            else
                return -1;
        }

        // divide
        int mid = (low+high)/2;

        // conquer
        if(arr[mid] == numberToFind){
            return mid;
        }

        else if(arr[mid] > numberToFind){
            return binarySearch(arr,low,mid-1,numberToFind);
        }
        else if(arr[mid] < numberToFind){
            return binarySearch(arr,mid+1,high,numberToFind);
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int [] arr = {2,5};
        System.out.println(binarySearch.binarySearch(arr,0,arr.length-1,1));
    }

}
