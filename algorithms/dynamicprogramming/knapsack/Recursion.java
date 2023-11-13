package algorithms.dynamicprogramming.knapsack;

public class Recursion {

    public static int knapsack(int [] weight, int [] value, int i, int capacity) {
        if(i < 0) {
            return 0;
        }

        if(weight[i] > capacity) {
            return knapsack(weight, value, i-1, capacity);
        }

        return Math.max(value[i] + knapsack(weight, value, i-1, capacity - weight[i]), knapsack(weight, value, i-1, capacity));
    }

    public static void main(String[] args) {
        System.out.println(knapsack(new int[] {12, 2, 1, 4, 1}, new int[]{4, 2, 1, 10, 2},4,15)); // 15
        System.out.println(knapsack(new int[] {4, 5, 1}, new int[]{1, 2, 3},2,4)); // 3
        System.out.println(knapsack(new int[] {4, 5, 6}, new int[]{1, 2, 3},2,3)); // 0
    }

}
