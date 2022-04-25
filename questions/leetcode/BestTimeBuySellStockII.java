package questions.leetcode;

import java.util.Stack;

/**
 * 122. Best Time to Buy and Sell Stock II
 */
public class BestTimeBuySellStockII {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        Stack<Integer> integerStack = new Stack<>();
        for(int i = 0 ; i < prices.length;i++){
            if(!integerStack.empty()){
                if(prices[i] > integerStack.peek()){
                    maxProfit += prices[i] - integerStack.pop();
                    integerStack.push(prices[i]);
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
