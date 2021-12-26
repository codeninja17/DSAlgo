package educative.arrays;

import java.util.Arrays;

public class ArrayOfProductsExceptSelf {

    static int[] findProduct(int[] arr){
        int[] result = new int[arr.length];
        int temp = 1;

        for(int i=0;i<arr.length;i++){
            result[i] = temp;
            temp*=arr[i];
        }

        temp = 1;
        for(int i= arr.length-1;i>=0;i--){
            result[i]*=temp;
            temp*=arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr =  {0,1,2,3,5};// {1,2,3,4};
        System.out.println(Arrays.toString(findProduct(arr)));
    }

}
