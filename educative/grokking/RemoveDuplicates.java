package educative.grokking;

public class RemoveDuplicates {

    public static int remove(int[] arr) {
        int nextNonDuplicate = 1;
        for(int i = 1; i<arr.length;i++){
            if(arr[nextNonDuplicate-1] != arr[i]){
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }
        return nextNonDuplicate;
    }

    public static void main(String[] args) {
        int [] arr = {2, 3, 3, 3, 6, 9, 9};
        System.out.println(remove(arr));
    }
}
