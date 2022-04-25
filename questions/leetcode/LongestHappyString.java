package questions.leetcode;

import java.util.*;

public class LongestHappyString {

    public static String longestDiverseString(int a, int b, int c) {
        HashMap<String,Integer> charFrequencyMap = new HashMap<>();
       if(a>0){
           charFrequencyMap.put("a",a);
       }
        if(b>0){
            charFrequencyMap.put("b",b);
        }

        if (c > 0) {
            charFrequencyMap.put("c",c);

        }
        PriorityQueue<Map.Entry<String,Integer>> entryPriorityQueue = new PriorityQueue<>((o1, o2) ->
                o2.getValue()-o1.getValue());
        entryPriorityQueue.addAll(charFrequencyMap.entrySet());
        String res = "";
        List<Map.Entry<String,Integer>> entryList = new ArrayList<>();
        while(!entryPriorityQueue.isEmpty() || (!entryList.isEmpty() &&  res.length()>2 && !res.substring(res.length() - 2).equals(entryList.get(0).getKey().concat(entryList.get(0).getKey())) ) ) {
            if(!entryList.isEmpty()) {
                Map.Entry<String,Integer> characterIntegerEntry = entryList.get(0);
                if(res.length()>=2 && !res.substring(res.length() - 2).equals(characterIntegerEntry.getKey().concat(characterIntegerEntry.getKey())))
                {
                    res+=characterIntegerEntry.getKey();
                    if(characterIntegerEntry.getValue()>1){
                        characterIntegerEntry.setValue(characterIntegerEntry.getValue()-1);
                        entryPriorityQueue.add(characterIntegerEntry);
                    }
                    entryList.remove(characterIntegerEntry);
                }
                else {
                    Map.Entry<String,Integer> characterIntegerE = entryPriorityQueue.poll();
                    res+=characterIntegerE.getKey();
                    if(characterIntegerE.getValue()>1){
                        characterIntegerE.setValue(characterIntegerE.getValue()-1);
                        entryPriorityQueue.add(characterIntegerE);
                    }
                }
            }else {
                Map.Entry<String,Integer> characterIntegerEntry = entryPriorityQueue.poll();
                if(res.length() < 2 || (res.length()>=2 && !res.substring(res.length() - 2).equals(characterIntegerEntry.getKey().concat(characterIntegerEntry.getKey())))){
                    res+=characterIntegerEntry.getKey();
                    if(characterIntegerEntry.getValue()>1){
                        characterIntegerEntry.setValue(characterIntegerEntry.getValue()-1);
                        entryPriorityQueue.add(characterIntegerEntry);
                    }
                }

                else{
                    entryList.add(characterIntegerEntry);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestDiverseString(2,4,1));
    }
}
