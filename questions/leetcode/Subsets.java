package questions.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 78. Subsets
 */
public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int i = 0 ; i < nums.length;i++){
            int size = res.size();
            for(int j=0;j<size;j++){
                List<Integer> list = new ArrayList<>(res.get(j));
                list.add(nums[i]);
                res.add(list);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3};
        System.out.println(subsets(arr));
    }


}
