package algorithms.dynamicprog;

public class KnapsackProblem {


    public static int maxKnapsack(int [] weights, int [] prices, int capacity) {
        return calculateMax(weights, prices, capacity, 0);
    }

    public static int calculateMax(int [] weights, int [] prices, int capacity, int i) {
        if(capacity <= 0 || i == weights.length) {
            return 0;
        }

        if(weights[i] > capacity) {
            return calculateMax(weights, prices, capacity, i+ 1);
        }

        return Math.max(calculateMax(weights, prices, capacity, i+ 1), prices[i] + calculateMax(weights, prices, capacity - weights[i], i+ 1));

    }


    public static void main(String[] args) {
        int [] weights = {1,2,4,5};
        int [] prices = {4,2,1,6};
        System.out.println(maxKnapsack(weights, prices, 8));
    }

}
