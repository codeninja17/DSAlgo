package questions.leetcode;

/**
 * 125. Valid Palindrome
 */
public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        int lp = 0;
        int ep = s.length()-1;
        s = s.toLowerCase();
        while(lp <= ep){
            while (lp<=ep && !Character.isLetterOrDigit(s.charAt(lp))){
                lp++;
            }
            while (lp<=ep && !Character.isLetterOrDigit(s.charAt(ep))){
                ep--;
            }
            if(lp<=ep && s.charAt(lp) != s.charAt(ep)){
                return false;
            }
            lp++;
            ep--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(ValidPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }

}
