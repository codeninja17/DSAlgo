package questions.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. Find All Anagrams in a String
 */
public class FindAllAnagrams {

    public static List<Integer> findAnagrams(String s, String p) {
        int [] charArr = new int[26];
        for(char c : p.toCharArray()){
            charArr[c - 97]++;
        }
        List<Integer> res = new ArrayList<>();
        int currCount = 0;
        int [] strCountArr = new int[26];
        for(int i = 0;i<s.length();i++){
            if(currCount < p.length()){
                strCountArr[s.charAt(i) - 97]++;
                currCount++;
            }

            if(currCount == p.length()){
                if(Arrays.equals(charArr,strCountArr)){
                    res.add(i-p.length()+1);
                }
                strCountArr[s.charAt(i-p.length()+1) - 97]--;
                currCount--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd","abc"));
    }

}
