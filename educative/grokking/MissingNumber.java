package educative.grokking;

public class MissingNumber {

    public static int findMissingNumber(int[] nums) {
        int i=0;

        while(i < nums.length){
            if (nums[i] < nums.length && nums[i] != nums[nums[i]]){
                swap(nums,i,nums[i]);
            }
            else i++;
        }

        for(int j=0;j<nums.length;j++){
            if(nums[j]!=j){
                return j;
            }
        }

        return -1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(MissingNumber.findMissingNumber(new int[] { 4, 0, 3, 1 }));
        System.out.println(MissingNumber.findMissingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
    }

}
