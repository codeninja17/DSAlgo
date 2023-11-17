package algorithms.recursion;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Substring {

    public static int allPossibleSubstring(String str) {
        Map<Character,Integer> integerMap = new HashMap<>();
        integerMap.put(str.charAt(0), 1);
        return allPossibleStrs(str,0,1,0, integerMap);
    }

    public static int allPossibleStrs(String str, int i , int j, int sum, Map<Character,Integer> integerMap) {
        if(i == str.length())  {
            return sum;
        }
        if(j == str.length()) {
            integerMap = new HashMap<>();
            if((i+1) < str.length())
                 integerMap.put(str.charAt(i+1),1);
            return allPossibleStrs(str,i+1,i+2, sum, integerMap);
        }
        char c = str.charAt(j);
        integerMap.put(c, integerMap.getOrDefault(c,0) +1);
        if(integerMap.size() > 1) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            sum+=(Collections.max(integerMap.values())-Collections.min(integerMap.values()));
        }
        return allPossibleStrs(str, i, j+1, sum, integerMap);
    }

    public static void main(String[] args) {
        System.out.println(allPossibleSubstring("aabbcc"));
    }
}
