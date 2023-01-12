package questions.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length-2; i++) {
            if( nums [i] > 0) break;
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                List<Integer> triplets = new ArrayList<>();
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                    triplets.add(nums[i]);
                    triplets.add(nums[left]);
                    triplets.add(nums[right]);
                    result.add(triplets);

                    while(left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    while(left < right && nums[right-1] == nums[right]) {
                        right--;
                    }
                    right--;
                    left++;
                }else if(sum > 0) {
                    right--;
                }else {
                    left++;
                }
            }
            while(i < nums.length-2 && nums[i] == nums[i+1]){
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int [] arr = {-3,3,0,-1,-1,2,0,1,-1,-1,-1,-1,-1,2,2,2,2,2,2,2,2,3,3,3,3,3,0};
        System.out.println(threeSum(arr));
    }

}
