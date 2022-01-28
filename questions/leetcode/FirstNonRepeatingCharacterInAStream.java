package questions.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstNonRepeatingCharacterInAStream {

    public int firstUniqChar(String s) {
        Map<String, Integer> strCountMap = new HashMap<>();
        Queue<String> stringQueue = new LinkedList<>();
        for (int i = 0 ; i< s.length() ; i++){
            char c = s.charAt(i);
            strCountMap.put(c+"",strCountMap.getOrDefault(c+"",0)+1);
            stringQueue.add(c+"");
        }
        int index = 0;
        while(!stringQueue.isEmpty()){
            String str = stringQueue.poll();
            if(strCountMap.get(str) == 1){
                return index;
            }
            else index++;
        }
        return -1;
    }


    public static void main(String[] args) {
        String str = "loveleetcode";
        FirstNonRepeatingCharacterInAStream firstNonRepeatingCharacterInAStream = new FirstNonRepeatingCharacterInAStream();
        System.out.println(firstNonRepeatingCharacterInAStream.firstUniqChar(str));

    }

}
