package questions.leetcode;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 1046. Last Stone Weight
 */
public class LastStoneWeight {

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            priorityQueue.add(stone);
        }
        while (priorityQueue.size() > 1) {
            int x = priorityQueue.poll();
            int y = priorityQueue.poll();
            int sum = Math.abs(x - y);
            if (sum > 0) priorityQueue.add(sum);
        }
        return priorityQueue.isEmpty() ? 0 : priorityQueue.poll();
    }

    public static void main(String[] args) {

    }
}
