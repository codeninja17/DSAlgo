package questions.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. Minimum Window Substring
 */
public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        Map<Character,Integer> stringIntegerMap = new HashMap<>();
        for (int i = 0;i<t.length();i++){
            stringIntegerMap.put(t.charAt(i),stringIntegerMap.getOrDefault(t.charAt(i),0)+1);
        }

        int startIndex = 0;
        int endIndex = Integer.MAX_VALUE-1;
        int count = 0;

        int j = 0;
        int k = 0;

        while(j < s.length() && k < s.length()){

            while (j<s.length() && !stringIntegerMap.containsKey(s.charAt(j))){
                j++;
                k = j;
            }
            if(j < s.length() && k<s.length()){
                char c = s.charAt(k);
                if(stringIntegerMap.containsKey(c)){
                    int freq = stringIntegerMap.get(c);
                    stringIntegerMap.put(c,freq-1);
                    if(freq > 0) {
                        count++;
                    }
                    else if(freq <= 0 && s.charAt(j) == c){
                        while(true){
                            if(stringIntegerMap.containsKey(s.charAt(j))){
                                int f = stringIntegerMap.get(s.charAt(j));
                                if(f >= 0) break;
                                else stringIntegerMap.put(s.charAt(j), f+1);
                            }
                            j++;
                        }
                    }
                }
                if(count == t.length()) {
                    if((k-j+1) < (endIndex - startIndex + 1)){
                        startIndex = j;
                        endIndex = k;
                    }
                    stringIntegerMap.put(s.charAt(j), stringIntegerMap.get(s.charAt(j))+1);
                    j++;
                    count--;
                    while(j<s.length()){
                        if(stringIntegerMap.containsKey(s.charAt(j))){
                            int f = stringIntegerMap.get(s.charAt(j));
                            if(f == 0 || f == t.length()) {
                                if( j > k) {
                                   j--;
                                   k = j;
                                }
                                break;
                            }
                            else if (f > 0) {
                                count--;
                                stringIntegerMap.put(s.charAt(j), stringIntegerMap.get(s.charAt(j))+1);
                            }
                            else stringIntegerMap.put(s.charAt(j), f+1);
                        }
                        j++;
                    }
                }
                k++;
            }
        }
        if(endIndex == Integer.MAX_VALUE -1) return "";
        return s.substring(startIndex,endIndex+1);
    }


    public static void main(String[] args) {
        System.out.println(minWindow("aaflslflsldkalskaaa","aaa"));
        System.out.println(minWindow("a","b"));
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
        System.out.println(minWindow("a","a"));
        System.out.println(minWindow("a","aa"));
        System.out.println(minWindow("aabdec","abc"));
        System.out.println(minWindow("aabdec","abac"));
        System.out.println(minWindow("baaaabab","abb"));
        System.out.println(minWindow("aAaabAbBaa","aaAB"));

    }

}
