package educative.grokking;

import java.util.Arrays;

public class SquaringSortedArray {

    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        int leftPtr = 0;
        int rightPtr = arr.length-1;
        int resultArrayPtr = squares.length-1;
        while(leftPtr <= rightPtr){
            if(Math.abs(arr[leftPtr]) > Math.abs(arr[rightPtr])){
                squares[resultArrayPtr] = arr[leftPtr] * arr[leftPtr];
                leftPtr++;
            }
            else{
                squares[resultArrayPtr] = arr[rightPtr] * arr[rightPtr];
                rightPtr--;
            }
            resultArrayPtr--;
        }
        return squares;
    }

    public static void main(String[] args) {
        int [] arr = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(makeSquares(arr)));
    }
}
