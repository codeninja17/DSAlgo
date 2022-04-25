package questions.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumProductTwoElementsArray {

    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i< nums.length;i++){
            priorityQueue.add(nums[i]);
        }
        return (priorityQueue.poll()-1) * (priorityQueue.poll()-1);
    }




}
