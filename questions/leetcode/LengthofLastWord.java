package questions.leetcode;

/**
 * 58. Length of Last Word
 */
public class LengthofLastWord {

    public int lengthOfLastWord(String s) {
        s = s.trim();
        int p = 0;
        for(int i = s.length()-1; i > 0 ; i--){
            if(s.charAt(i) ==  ' '){
                p = i+1;
                break;
            }
        }
        return s.substring(p,s.length()).length();
    }

}
