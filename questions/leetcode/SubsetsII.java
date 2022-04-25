package questions.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. Subsets II
 */
public class SubsetsII {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        int startIndex = 0;
        int endIndex = res.size()-1;
        for(int j = 0 ; j<nums.length ;j++){
            if(j>0 && nums[j] == nums[j-1])
                startIndex = endIndex+1;
            else startIndex = 0;
            endIndex = res.size()-1;

            for(int i = startIndex ; i<=endIndex ; i++){
                List<Integer> list = new ArrayList<>(res.get(i));
                list.add(nums[j]);
                res.add(list);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int [] arr = {4,4,4,1,4};
        System.out.println(subsetsWithDup(arr));
    }

}
