package questions.leetcode;

import java.util.*;

/*
239. Sliding Window Maximum
 */
public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int windowCount = 0;
        int [] res = new int[nums.length - k+1];
        int resCnt = 0;
        Deque<Integer> integerDeque = new ArrayDeque<>();
        for (int i = 0 ; i < nums.length ; i++){
            if(!integerDeque.isEmpty() && integerDeque.peekFirst() < (i-k+1)){
                integerDeque.pollFirst();
            }
            while(!integerDeque.isEmpty() && nums[integerDeque.peekLast()] < nums[i]){
                integerDeque.pollLast();
            }
            integerDeque.addLast(i);
            windowCount++;
            if(windowCount >= k){
                windowCount = k-1;
                res[resCnt++] = nums[integerDeque.peekFirst()];
            }
        }
        return res;
    }
 /* priority queue solution is valid but causes TLE for  priorityQueue.remove(nums[windowStart]);
    priorityQueue.remove has a time complexity of O(n) and it causes TLE for large size of window K >= 50000
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int windowStart = 0;
        int [] res = new int[nums.length - k+1];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0 ; i < nums.length ; i++){
            priorityQueue.add(nums[i]);
            if(i >= k-1){
                res[windowStart] = priorityQueue.peek();
                priorityQueue.remove(nums[windowStart]);
                windowStart++;
            }
        }
        return res;
    }
 */

    public static void main(String[] args) {
        int [] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums,3)));
    }

}
