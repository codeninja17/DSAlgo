package questions.leetcode;

import java.util.*;

/**
 * 151. Reverse Words in a String
 */
public class ReverseWordsString {

    public static String reverseWords(String s) {
        String [] strings = s.trim().split("\\s+");
        int n = strings.length-1;
        s="";
        while (n>=0){
            s += strings[n]+" ";
            n--;
        }
        return s.substring(0,s.length()-1);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("agoodexample"));
        String s = "agoodexamplxe";
        Map<Character,Integer> map = new HashMap<>();
        for (char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        Comparator<Map.Entry<Character,Integer>> strComp = Comparator
                .comparing(Map.Entry<Character,Integer>::getValue).reversed().thenComparing(Map.Entry<Character,Integer>::getKey);
        SortedSet<Map.Entry<Character,Integer>> sortedSet = new TreeSet<>(strComp);
        sortedSet.addAll(map.entrySet());
        System.out.println(sortedSet);
    }

}
