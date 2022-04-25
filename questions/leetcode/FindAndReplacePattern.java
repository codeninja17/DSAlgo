package questions.leetcode;

import java.util.*;

/**
 * 890. Find and Replace Pattern
 */
public class FindAndReplacePattern {

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for(int i = 0 ; i < words.length ;i++){
            Map<Character,Character> wordToPatternMap = new HashMap<>();
            Map<Character,Character> patternToWordMap = new HashMap<>();
            int count = 1;
            for(int j = 0 ; j<words[i].length();j++){
                Character word = words[i].charAt(j);
                Character p = pattern.charAt(j);

                Character c_word = wordToPatternMap.get(word);
                Character c_patt = patternToWordMap.get(p);

                if(c_word!=null && c_patt!=null){
                    if(!(c_word.equals(p) && c_patt.equals(word))) count++;
                }
                else if(c_word == null && c_patt!=null){
                    if(!c_patt.equals(word)) count++;
                }
                else if(c_patt == null && c_word!=null){
                    if(!c_word.equals(p)) count++;
                }
                wordToPatternMap.put(word,p);
                patternToWordMap.put(p,word);
            }

            if(count == 1) res.add(words[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        String [] arr = {"dkd","ccc"};
        System.out.println((findAndReplacePattern(arr,"abb")));
    }
}
