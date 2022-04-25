package questions.leetcode;

import java.util.Stack;

/**
 * 1047. Remove All Adjacent Duplicates In String
 */
public class RemoveAllAdjacentDuplicatesInString {

    public static String removeDuplicates(String s) {
        Stack<Character> stringStack = new Stack<>();
        for (int i=0;i<s.length();i++){
            Character c = s.charAt(i);
            if(!stringStack.empty() && stringStack.peek().equals(c)){
                while(!stringStack.empty() && stringStack.peek().equals(c)){
                    stringStack.pop();
                }
            }
            else stringStack.push(c);
        }
        String res = "";
        while (!stringStack.empty()){
            res = stringStack.pop() + res;
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "abbaca";
        System.out.println(removeDuplicates(str));

    }

}
