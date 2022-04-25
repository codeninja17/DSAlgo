package questions.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeastNumberofUniqueIntegersAfterKRemovals {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer> integerHashMap = new HashMap<>();
        for(int n: arr){
            integerHashMap.put(n,integerHashMap.getOrDefault(n,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> entryPriorityQueue = new PriorityQueue<>((o1, o2) ->
        o2.getValue()-o1.getValue());

        entryPriorityQueue.addAll(integerHashMap.entrySet());

        while (!entryPriorityQueue.isEmpty() && k>0){
            Map.Entry<Integer,Integer> entry = entryPriorityQueue.poll();
            int count = entry.getValue();
            while(count > 0 && k>0){
                k--;
                count--;
            }
            if(count > 0) {
                entry.setValue(count);
                entryPriorityQueue.offer(entry);
            }
        }
        while (!entryPriorityQueue.isEmpty() && !entryPriorityQueue.peek().getValue().equals(1)) entryPriorityQueue.remove();


        return entryPriorityQueue.size();
    }

}
