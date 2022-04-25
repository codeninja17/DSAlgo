package questions.leetcode;

/**
 * 922. Sort Array By Parity II
 */
public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] nums) {
        int j = 0;
        for (int i = 0 ; i <nums.length ; i++){
            if (i % 2 == 0) {
                if(nums[i] % 2 != 0){
                    j = i+1;
                    while (j < nums.length) {
                        if(nums[j] % 2 == 0) {
                            swap(nums,i,j);
                            break;
                        }
                        j+=2;
                    }
                }
            }else {
                if(nums[i] % 2 == 0){
                    j = i+1;
                    while (j < nums.length) {
                        if(nums[j] % 2 != 0) {
                            swap(nums,i,j);
                            break;
                        }
                        j+=2;
                    }
                }
            }
        }
        return nums;
    }

    static void swap(int[] nums , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
