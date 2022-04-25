package questions.leetcode;

public class ValidMountainArray {

    public static boolean validMountainArray(int[] arr) {
        if(arr.length == 1 || arr.length == 2 ) return false;
        int i = 0;
        for(i=0;i<arr.length-1;i++){
           if(arr[i] == arr[i+1]){
               return false;
           }
           if(arr[i] > arr[i+1]){
               break;
           }
        }

        if(i+1 == arr.length || i == 0) return false;
        for(int j = i+1 ; j <arr.length-1;j++){
            if(arr[j]<= arr[j+1]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int [] arr = {9,8,7,6,5,4,3,2,1,0};
        System.out.println(validMountainArray(arr));
    }

}
