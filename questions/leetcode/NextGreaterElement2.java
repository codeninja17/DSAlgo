package questions.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * 503. Next Greater Element II
 */
public class NextGreaterElement2 {

    public static int[] nextGreaterElements(int[] nums) {
        int [] res = new int[nums.length];
        Arrays.fill(res,-1);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i<nums.length*2;i++){
           while (!stack.empty() && nums[stack.peek()] < nums[i % nums.length]){
               res[stack.pop()] = nums[i % nums.length];
           }
           stack.push(i % nums.length);
        }
        return res;
    }

    public static void main(String[] args) {
        int [] nums = {1,2,1};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }

}
