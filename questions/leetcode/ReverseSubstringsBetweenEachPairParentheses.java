package questions.leetcode;

import java.util.Stack;

public class ReverseSubstringsBetweenEachPairParentheses {


    public static String reverseParentheses(String s) {
        Stack<Integer> integerStack = new Stack<>();
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) == '(') integerStack.push(i);
            else if(s.charAt(i) == ')') {
                int index = integerStack.pop();
                String str = "";
                int j = i-1;
                while(j >= index+1){
                    str+=s.charAt(j);
                    j--;
                }
                s = s.substring(0,index) + str + s.substring(i+1);
                i = i-2;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(reverseParentheses("(ed(et(oc))el)"));
    }

}
