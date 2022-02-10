package educative.grokking;

import java.util.ArrayList;
import java.util.List;

public class AllMissingNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int i = 0 ;
        while (i < nums.length) {
            if(nums[i] != nums[nums[i]-1])
                swap(nums, i, nums[i] - 1);
            else
                i++;
        }
        for (i = 0; i < nums.length; i++)
            if (nums[i] != i + 1)
                res.add(i + 1);
    return res;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
