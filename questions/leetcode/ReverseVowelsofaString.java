package questions.leetcode;

import java.util.Set;

/**
 *
 * 345. Reverse Vowels of a String
 */
public class ReverseVowelsofaString {

    public static String reverseVowels(String s) {
        int i = 0;
        int j = s.length()-1;
        Set<Character> characterSet = Set.of('a','e','i','o','u','A','E','I','O','U');
        while(i<j){
            while(i < s.length() && !characterSet.contains(s.charAt(i))){
                i++;
            }
            while (j >=0 && !characterSet.contains(s.charAt(j))){
                j--;
            }
            if(i<j && j<s.length() && j+1 <=s.length()){
                s = s.substring(0,i) + s.charAt(j) + s.substring(i+1,j)+s.charAt(i)+s.substring(j+1);
                i++;
                j--;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("race car"));
    }

}
