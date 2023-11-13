package algorithms.dynamicprogramming.knapsack;

public class BottomDown {

    public static int knapsack(int [] weight, int [] value, int capacity) {
        int [][] tab = new int[weight.length+1][capacity + 1];
        for (int i = 1; i < tab.length; i++) {
            for(int j = 1; j < tab[0].length ; j++) {
               if(weight[i-1] > j) {
                   tab[i][j] = tab[i-1][j];
               }
               else {
                   tab[i][j] = Math.max(value[i-1] + tab[i-1][j- weight[i-1]], tab[i-1][j]);
               }
            }
        }
        return tab[weight.length][capacity];
    }

    public static void main(String[] args) {
        System.out.println(knapsack(new int[] {12, 2, 1, 4, 1}, new int[]{4, 2, 1, 10, 2},15)); // 15
        System.out.println(knapsack(new int[] {4, 5, 1}, new int[]{1, 2, 3},4)); // 3
        System.out.println(knapsack(new int[] {4, 5, 6}, new int[]{1, 2, 3},3)); // 0
    }


}
