package educative.Stack;

import java.util.Stack;

public class FindCelebChallenge {

    public static int findCelebrity(int[][] party, int numPeople) {
        int celebrity = -1;
        Stack<Integer> integerStack = new Stack<>();
        while (numPeople >= 0){
            integerStack.push(--numPeople);
        }

        while (integerStack.size() > 1){
            int p1 = integerStack.pop();
            int p2 = integerStack.pop();
            if(party[p1][p2] == 1){
                integerStack.push(p2);
            }else if (party[p2][p1] == 1) {
                integerStack.push(p1);
            }
        }
        if(!integerStack.isEmpty()) celebrity = integerStack.pop();
        return celebrity;
    }

}
