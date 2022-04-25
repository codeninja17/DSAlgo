package questions.leetcode;

import java.util.HashMap;

/**
 * 992. Subarrays with K Different Integers
 */
public class SubarraysWithKDifferentIntegers {

    public int subarraysWithKDistinct(int[] nums, int k) {
        if(nums.length == 1) return 1;
        HashMap<Integer,Integer> integerHashMap = new HashMap<>();
        int i = 0;
        int j = 1;
        integerHashMap.put(nums[i],1);
        while (i<nums.length){
            integerHashMap.put(nums[j],integerHashMap.getOrDefault(nums[j],0)+1);
            if(integerHashMap.size() == k){
                int p = j;
                j++;
            }else if(integerHashMap.size() > k){

            }else {
                j++;
            }

        }

        return -1;
    }

}
