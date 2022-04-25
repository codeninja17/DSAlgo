package questions.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 767. Reorganize String
 */
public class ReorganizeString {

    public static String reorganizeString(String s) {
        String res ="";
        HashMap<Character,Integer> charFrequencyMap = new HashMap<>();
        for(int i = 0; i <s.length();i++){
            charFrequencyMap.put(s.charAt(i),charFrequencyMap.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> entryPriorityQueue = new PriorityQueue<>((o1, o2) ->
                o2.getValue()-o1.getValue());
        entryPriorityQueue.addAll(charFrequencyMap.entrySet());
        Map.Entry<Character,Integer> prev = null;
        while(!entryPriorityQueue.isEmpty()){
            Map.Entry<Character,Integer> curr = entryPriorityQueue.poll();
            res = res+curr.getKey();
            if(prev!=null && prev.getValue()>1) {
                prev.setValue(prev.getValue()-1);
                entryPriorityQueue.add(prev);
            }
            prev = curr;
        }
        if(prev!=null && prev.getValue()>1) return "";
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("abca"));
    }

}
