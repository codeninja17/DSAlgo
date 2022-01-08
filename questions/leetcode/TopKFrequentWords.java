package questions.leetcode;


import java.util.*;

/**
 * 692 Top K frequent Words
 */

public class TopKFrequentWords {

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> wordCountMap = new HashMap<>();
        for (String str : words){
            int count = 0;
            if(wordCountMap.containsKey(str)) {
                count = wordCountMap.get(str);
            }
                wordCountMap.put(str,++count);
            }
        PriorityQueue<Map.Entry<Integer,String>>
                priorityQueue = new PriorityQueue<>(Map.Entry.<Integer,String>comparingByKey().
                reversed().thenComparing(Map.Entry.comparingByValue()));
        for (Map.Entry<String,Integer> entry : wordCountMap.entrySet()){
            priorityQueue.add(Map.entry(entry.getValue(),entry.getKey()));
        }
        System.out.println(priorityQueue);
        List<String> stringList = new ArrayList<>();
        for(int i = k-1; i>=0 ;i--){
            stringList.add(priorityQueue.poll().getValue());
        }
        return stringList;
    }

    public static void main(String[] args) {
        String [] words = {"i","love","leetcode","i","love","coding"};
        List<String> stringList = topKFrequent(words,2);
        System.out.println(stringList);
    }

}
