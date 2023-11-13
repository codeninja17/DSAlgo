package algorithms.dynamicprogramming.knapsack;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TopDown {

    private static Map<Tuple<Integer, Integer>, Integer> memo;

    public static int knapsack(int [] weight, int [] value, int i, int capacity) {
        Tuple<Integer, Integer> t = new Tuple<>(i, capacity);
        if(i < 0) {
            return 0;
        }

        if(memo.containsKey(t)) {
            return memo.get(t);
        }

        if(weight[i] > capacity) {
            memo.put(t, knapsack(weight, value, i-1, capacity));
            return memo.get(t);
        }

        memo.put(t, Math.max(value[i] + knapsack(weight, value, i-1, capacity - weight[i]), knapsack(weight, value, i-1, capacity)));
        return memo.get(t);
    }

    public static void main(String[] args) {
        memo = new HashMap<>();
        System.out.println(knapsack(new int[] {12, 2, 1, 4, 1}, new int[]{4, 2, 1, 10, 2},4,15)); // 15
        memo = new HashMap<>();
        System.out.println(knapsack(new int[] {4, 5, 1}, new int[]{1, 2, 3},2,4)); // 3
        memo = new HashMap<>();
        System.out.println(knapsack(new int[] {4, 5, 6}, new int[]{1, 2, 3},2,3)); // 0
    }

}

class Tuple<K,V> {

    private K key1;
    private V key2;

    public Tuple(K key1, V key2) {
        this.key1 = key1;
        this.key2 = key2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple<?, ?> tuple = (Tuple<?, ?>) o;
        return key1.equals(tuple.key1) &&
                key2.equals(tuple.key2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key1, key2);
    }
}
