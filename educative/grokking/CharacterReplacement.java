package educative.grokking;

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {

    public static int findLength(String str, int k) {
       HashMap<Character,Integer> characterIntegerHashMap = new HashMap<>();
       int windowStart = 0;
       int maxRepeatedChar = 0;
       int maxLength = 0;
       for(int i=0;i<str.length();i++){
            Character c = str.charAt(i);
            characterIntegerHashMap.put(c,characterIntegerHashMap.getOrDefault(c,0)+1);
            maxRepeatedChar = Math.max(maxRepeatedChar,characterIntegerHashMap.get(c));

            if(i - windowStart + 1 - maxRepeatedChar > k){
                Character ch = str.charAt(windowStart);
                characterIntegerHashMap.put(ch,characterIntegerHashMap.get(ch)-1);
                windowStart++;
            }
            maxLength = Math.max(maxLength,i-windowStart+1);
       }

       return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(CharacterReplacement.findLength("aabccbb", 2));
        System.out.println(CharacterReplacement.findLength("abbcb", 1));
        System.out.println(CharacterReplacement.findLength("abccde", 1));
        System.out.println(CharacterReplacement.findLength("", 1));
        System.out.println(CharacterReplacement.findLength(" ", 1));
    }
}
