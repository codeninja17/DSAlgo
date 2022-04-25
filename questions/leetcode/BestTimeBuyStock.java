package questions.leetcode;

import java.util.LinkedList;
import java.util.Stack;

/*
121. Best Time to Buy and Sell Stock
 */
public class BestTimeBuyStock {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        Stack<Integer> integerStack = new Stack<Integer>();

        for(int i = 0 ; i < prices.length;i++){
            if(!integerStack.empty()){
                if(prices[i] > integerStack.peek()){
                    maxProfit = Math.max(maxProfit,prices[i] - integerStack.peek());
                }else if(prices[i] < integerStack.peek()){
                    integerStack.pop();
                    integerStack.push(prices[i]);
                }
            }
            else integerStack.push(prices[i]);
        }

        return maxProfit;
    }

}
