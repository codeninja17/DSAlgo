package questions.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 442. Find All Duplicates in an Array
 */
public class FindAllDuplicatesArray {

    public static List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        while(i<nums.length){
            while(i+1 != nums[i] && nums[nums[i]-1]!=nums[i]){
                int temp = nums[i];
                nums[i] = nums[nums[i]-1];
                nums[temp-1] = temp;
            }
            i++;
        }
        System.out.println(Arrays.toString(nums));
        List<Integer> res = new ArrayList<>();
        for (int j = 0; j<nums.length;j++){
            if(j+1!=nums[j]){
                res.add(nums[j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int [] arr = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(arr));
    }

}
