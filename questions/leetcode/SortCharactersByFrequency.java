package questions.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 451. Sort Characters By Frequency
 */
public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        Map<Character,Integer> characterIntegerMap = new HashMap<>();
        for(int i = 0 ; i<s.length();i++){
            characterIntegerMap.put(s.charAt(i),characterIntegerMap.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> priorityQueue = new PriorityQueue<>
                ((o1, o2) -> o2.getValue()-o1.getValue());
        priorityQueue.addAll(characterIntegerMap.entrySet());
        String res = "";
        while(!priorityQueue.isEmpty()){
            Map.Entry<Character,Integer> entry = priorityQueue.poll();
            for(int i = 0 ; i < entry.getValue();i++){
                res+=entry.getKey();
            }
        }
        return res;
    }

}
