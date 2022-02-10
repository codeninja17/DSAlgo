package questions.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * 739. Daily Temperatures
 */
public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Arrays.fill(res,0);
        Stack<Integer> integerStack = new Stack<>();
        for(int i = 0; i<temperatures.length;i++){
            while(!integerStack.empty() && temperatures[integerStack.peek()] < temperatures[i]){
                int index = integerStack.pop();
                res[index] = i-index;
            }
            integerStack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int [] temp = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temp)));
    }

}
