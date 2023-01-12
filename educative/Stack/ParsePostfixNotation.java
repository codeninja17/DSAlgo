package educative.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class ParsePostfixNotation {

    public static int evaluatePostFix(String expression) {
        Stack<Integer> expStack = new Stack<>();
        Map<Character, BiFunction<Integer,Integer,Integer>> stringFunctionMap = getExpressionMap();
        for(int i = 0; i < expression.length() ;i++){
            char c = expression.charAt(i);
            if(stringFunctionMap.containsKey(c)){
                int num1 = expStack.pop();
                int num2 = expStack.pop();
                int res =  stringFunctionMap.get(c).apply(num2,num1);
                expStack.push(res);
            }
            else {
                expStack.push(Character.getNumericValue(c));
            }
        }
        return expStack.pop();
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> expStack = new Stack<>();
        Map<String, BiFunction<Integer,Integer,Integer>> stringFunctionMap = getExpressionStringMap();
        for(int i = 0; i < tokens.length ;i++){
            String s = tokens[i];
            if(stringFunctionMap.containsKey(s)){
                int num1 = expStack.pop();
                int num2 = expStack.pop();
                int res =  stringFunctionMap.get(s).apply(num2,num1);
                expStack.push(res);
            }
            else {
                expStack.push(Integer.parseInt(s));
            }
        }
        return expStack.pop();
    }

    public static Map<Character, BiFunction<Integer,Integer,Integer>> getExpressionMap(){
        Map<Character, BiFunction<Integer,Integer,Integer>> stringFunctionMap = new HashMap<>();
        stringFunctionMap.put('+', Math::addExact);
        stringFunctionMap.put('*', Math::multiplyExact);
        stringFunctionMap.put('-', Math::subtractExact);
        stringFunctionMap.put('/', (a,b) -> a/b);
        return stringFunctionMap;
    }

    public static Map<String, BiFunction<Integer,Integer,Integer>> getExpressionStringMap(){
        Map<String, BiFunction<Integer,Integer,Integer>> stringFunctionMap = new HashMap<>();
        stringFunctionMap.put("+", Math::addExact);
        stringFunctionMap.put("*", Math::multiplyExact);
        stringFunctionMap.put("-", Math::subtractExact);
        stringFunctionMap.put("/", (a,b) -> a/b);
        return stringFunctionMap;
    }

    public static void main(String[] args) {
        String s = "921*-8-4+";
        System.out.println(evaluatePostFix(s));

        String [] tokens =  {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }

}
