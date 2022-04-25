package questions.leetcode;

import java.util.HashMap;

/**
 * 219 Contains Duplicate II
 */
public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> integerHashMap = new HashMap<>();
        for(int i = 0 ; i < nums.length ;i++){
            if(integerHashMap.containsKey(nums[i]) && Math.abs(integerHashMap.get(nums[i])-i) <=k){
                return true;
            }
            integerHashMap.put(nums[i],i);
        }
        return false;
    }

}
