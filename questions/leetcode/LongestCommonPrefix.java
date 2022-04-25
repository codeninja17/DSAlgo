package questions.leetcode;

import java.util.HashMap;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        if(prefix.isBlank()) return "";
        for (int i = 1; i<strs.length;i++){
            int j = 0;
            int count = 0;
            while (j < strs[i].length() && j < prefix.length()){
                if(strs[i].charAt(j) != prefix.charAt(j)) break;
                count++;
                j++;
            }
            if(count == 0) return "";
            else {
                prefix = prefix.substring(0,count);
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String [] newArr = {"aaa","aa","aaa"};
        System.out.println(longestCommonPrefix(newArr));
    }

}
