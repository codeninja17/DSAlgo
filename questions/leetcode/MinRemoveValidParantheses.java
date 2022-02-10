package questions.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 1249. Minimum Remove to Make Valid Parentheses
 */
public class MinRemoveValidParantheses {

    public static String minRemoveToMakeValid(String s) {
        Map<Character,Character> parenthesisMap = new HashMap<>();
        parenthesisMap.put('(',')');
        Stack<Integer> integerStack = new Stack<>();
        for(int i=0; i<s.length();i++){
            Character c = s.charAt(i);
            if(c.equals('(')|| c.equals(')')){
                if(!integerStack.empty() && parenthesisMap.get(s.charAt(integerStack.peek()))!=null
                        && parenthesisMap.get(s.charAt(integerStack.peek())).equals(c)){
                    integerStack.pop();
                }else {
                    integerStack.push(i);
                }
            }
        }

        while (!integerStack.empty()){
            int index = integerStack.pop();
            s = s.substring(0,index)+s.substring(index+1,s.length());
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("))(("));
    }


}
