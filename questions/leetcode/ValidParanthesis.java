package questions.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParanthesis {


    public boolean isValid(String s){
        boolean result = false;
        Map<Character,Character> paranthesisMap =   getParenthesisMap();
        Stack<Character> characters = new Stack<>();
        for(int i = 0; i<s.length() ;i++){
            Character endingParanthesis = paranthesisMap.get(s.charAt(i));
            if(characters.isEmpty() && i == s.length()-1){
                return false;
            }
            else if(endingParanthesis != null){
                characters.push(s.charAt(i));
            }else{
                Character lastChar = characters.isEmpty() ? null : characters.pop();
                if(lastChar!=null && (paranthesisMap.get(lastChar)).equals(s.charAt(i))){
                    result = true;
                }
                else {
                    result = false;
                    break;
                }
            }
        }
        if(!characters.isEmpty()) result = false;
        return result;
    }

    private Map<Character,Character> getParenthesisMap(){
        Map<Character,Character> parenthesisMap = new HashMap<>();
        parenthesisMap.put('(',')');
        parenthesisMap.put('[',']');
        parenthesisMap.put('{','}');
        return parenthesisMap;
    }

    public static void main(String[] args) {
        String s = "([]";
        ValidParanthesis validParanthesis = new ValidParanthesis();
        System.out.println(validParanthesis.isValid(s));
    }

}
