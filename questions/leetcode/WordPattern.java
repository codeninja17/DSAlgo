package questions.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 290. Word Pattern
 */
public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");
        HashMap<Character,String> patterToStringMap = new HashMap<>();
        HashMap<String,Character> stringToPatternMap = new HashMap<>();
        int i=0;
        int j=0;
        while(i < pattern.length() && j < strings.length){
            char c = pattern.charAt(i);
            String str = strings[i].trim();
            if(patterToStringMap.containsKey(c) || stringToPatternMap.containsKey(str)){
                String s1 = patterToStringMap.get(c);
                if(s1!=null && !s1.equals(str)){
                    return false;
                }
                Character character = stringToPatternMap.get(str);
                if (character!=null && !character.equals(c)){
                    return false;
                }
            }
            else {
                patterToStringMap.put(c,str);
                stringToPatternMap.put(str,c);
            }
            i++;
            j++;
        }
        if(i != pattern.length() || j != strings.length){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("aaa","aa aa aa aa"));
    }

}
