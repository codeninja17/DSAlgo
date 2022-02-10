package educative.grokking;

import java.util.HashMap;

public class LongestSubstringwithDistinctCharacters {

    public static int findLength(String str) {
        if(str.isEmpty()) return 0;
        HashMap<Character,Character> characterHashMap = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;
        int currLength = 0;
        int windowStart = 0;
        for(int i=0;i<str.length();i++){
            Character c = str.charAt(i);
            if(characterHashMap.containsKey(c)){
                while(!new Character(str.charAt(windowStart)).equals(c)){
                    characterHashMap.remove(str.charAt(windowStart));
                    windowStart++;
                    currLength--;
                }
                characterHashMap.remove(str.charAt(windowStart++));
                characterHashMap.put(c,c);
            }else{
                characterHashMap.put(c,c);
                currLength++;
            }
            if (currLength > maxLength) {
                maxLength = currLength;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(findLength(" "));
    }

}
