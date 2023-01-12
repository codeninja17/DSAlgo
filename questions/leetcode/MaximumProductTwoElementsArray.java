package questions.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumProductTwoElementsArray {

//    public int maxProduct(int[] nums) {
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
//        for(int i = 0; i< nums.length;i++){
//            priorityQueue.add(nums[i]);
//        }
//        return (priorityQueue.poll()-1) * (priorityQueue.poll()-1);
//    }1

    public static int maxProduct(int[] nums) {
        int maxPos = Integer.MIN_VALUE;
        int secondMaxPos = Integer.MIN_VALUE;

        int maxNeg = Integer.MIN_VALUE;
        int secondMaxNeg = Integer.MIN_VALUE;
        boolean containsPos = false;
        boolean containsNeg = false;

        for(int i = 0; i <nums.length;i++) {
            if (nums[i] >= 0) {
                containsPos = true;
                if (nums[i] > maxPos) {
                    secondMaxPos = maxPos;
                    maxPos = nums[i];
                } else if (nums[i] > secondMaxPos) {
                    secondMaxPos = nums[i];
                }
            } else {
                containsNeg = true;
                if (Math.abs(nums[i])> Math.abs(maxNeg)) {
                    secondMaxNeg = maxNeg;
                    maxNeg = nums[i];
                }else if(Math.abs(nums[i]) > Math.abs(secondMaxNeg)) secondMaxNeg = nums[i];
            }
        }
        if(containsNeg && containsPos)
          return Math.max((maxPos-1)*(secondMaxPos-1),(maxNeg-1)*(secondMaxNeg-1));

        else if (containsNeg) return (maxNeg-1)*(secondMaxNeg-1);
        return (maxPos-1)*(secondMaxPos-1);
    }

    public static void main(String[] args) {
        int [] arr = {1,1,1,1};
        System.out.println(maxProduct(arr));
    }



}
