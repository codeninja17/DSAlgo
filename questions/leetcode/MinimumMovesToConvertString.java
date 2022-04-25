package questions.leetcode;

/**
 * 2027. Minimum Moves to Convert String
 */
public class MinimumMovesToConvertString {

    public static int minimumMoves(String s) {
        int count = 0;
        int i = 0;

        while(i<s.length()){
            if(s.charAt(i) == 'O') {
                i++;
                continue;
            }
            count++;
            i+=3;
        }
        return count;
    }
}
