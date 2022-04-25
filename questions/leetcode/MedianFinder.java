package questions.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 295. Find Median from Data Stream
 */
public class MedianFinder {

    PriorityQueue<Integer> minHeap = null;
    PriorityQueue<Integer> maxHeap = null;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(maxHeap.isEmpty() || maxHeap.peek() > num) maxHeap.add(num);
        else minHeap.add(num);

        if(minHeap.size()>maxHeap.size()){
            while (maxHeap.size()!=minHeap.size()){
                maxHeap.add(minHeap.poll());
            }
        }
        else if(maxHeap.size() > minHeap.size()+1){
            minHeap.add(maxHeap.poll());
        }

    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        }
        return maxHeap.peek();
    }


}
