package questions.leetcode;

import java.util.Stack;

public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> integerStack = new Stack<>();
        int j = 0;
        for(int i=0;i<pushed.length;i++) {
            integerStack.push(pushed[i]);
            while (!integerStack.isEmpty() && integerStack.peek() == popped[j]){
                integerStack.pop();
                j++;
            }
        }
        if(integerStack.isEmpty()) return true;
        return false;
    }

    public static void main(String[] args) {
    }

}
