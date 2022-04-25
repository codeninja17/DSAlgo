package questions.leetcode;

/**
 * 389. Find the Difference
 */
public class FindTheDifference {

    public static char findTheDifference(String s, String t) {
        int charCodes = t.charAt(s.length());
        for(int i = 0; i<s.length();i++){
            charCodes-=s.charAt(i);
            charCodes+=t.charAt(i);
        }
        return (char) charCodes;
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("abc","yabc"));
    }

}
