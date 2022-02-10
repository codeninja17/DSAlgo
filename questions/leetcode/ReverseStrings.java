package questions.leetcode;

import java.util.Arrays;

/**
 * 344. Reverse String
 */
public class ReverseStrings {

    public static void reverseString(char[] s) {
        int leftPtr = 0;
        int rightPtr = s.length-1;
        while(leftPtr <= rightPtr){
            char temp = s[leftPtr];
            s[leftPtr] = s[rightPtr];
            s[rightPtr] = temp;
            leftPtr++;
            rightPtr--;
        }
        System.out.println(Arrays.toString(s));
    }

    public static void main(String[] args) {
        char [] c = {};
        reverseString(c);
    }

}
