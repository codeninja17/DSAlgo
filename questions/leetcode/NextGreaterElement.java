package questions.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 496. Next Greater Element I
 */
public class NextGreaterElement {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> integerMap = new HashMap<>();
        Stack<Integer> integerStack = new Stack<>();
        for(int i = 0 ; i<nums2.length;i++){
            while(!integerStack.empty() && integerStack.peek() < nums2[i]){
                integerMap.put(integerStack.pop(),nums2[i]);
            }
            integerStack.push(nums2[i]);
        }

        int [] result = new int[nums1.length];
        for(int i = 0 ; i < nums1.length ;i++){
            result[i] = integerMap.getOrDefault(nums1[i],-1);
        }
        return result;
    }

    public static void main(String[] args) {
        int [] nums = {4,1,2};
        int [] numberStore = {1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement(nums,numberStore)));
    }

}
