package questions.leetcode;

import java.util.*;

/**
 * 347. Top K Frequent Elements
 */
public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> integerCountHashMap = new HashMap<>();
        for (int i = 0 ; i<nums.length;i++){
            integerCountHashMap.put(nums[i],integerCountHashMap.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> entryPriorityQueue = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer,Integer> entry : integerCountHashMap.entrySet()){
            entryPriorityQueue.add(entry);
            if(entryPriorityQueue.size() > k){
                entryPriorityQueue.remove();
            }
        }
        List<Integer> topNumbers = new ArrayList<>(k);
        while (!entryPriorityQueue.isEmpty()) {
            topNumbers.add(entryPriorityQueue.poll().getKey());
        }
        return topNumbers.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int [] arr = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(arr,2)));
    }

}

