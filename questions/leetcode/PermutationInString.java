package questions.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

    public static boolean checkInclusion(String s1, String s2) {

        if(s2.length() < s1.length()) return false;

        int []  charCountArr = new int[26];
        Arrays.fill(charCountArr,0);
        for (int i = 0; i < s1.length();i++) {
            int c = s1.charAt(i) - 'a';
            charCountArr[s1.charAt(i)-'a']++;
        }
        for(int i = 0 ; i<s2.length()-s1.length();i++){
            int [] s2Arr = new int [26];
            for(int j = 0 ; j<s1.length();j++){
                s2Arr[s2.charAt(i+j) - 'a']++;
            }
            if(matches(charCountArr,s2Arr)) return true;

        }
        return false;
    }

    private static boolean matches(int[] arr, int [] arr2){
        for(int i = 0 ; i <26;i++){
            if(arr[i]!=arr2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "ba";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1,s2));
    }
}
