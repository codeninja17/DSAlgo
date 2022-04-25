package datastructures;

import java.util.Arrays;

public class HashMap {

    private int [] buckets;
    private int currentSize;

    public HashMap() {
        buckets = new int[1000000];
        currentSize = 0;
        Arrays.fill(buckets,-1);
    }

    public void put(int key, int value) {
        key = key % buckets.length;
        buckets[key] = value;
        currentSize++;
    }

    public int get(int key) {
        key = key % buckets.length;
        return buckets[key];
    }

    public void remove(int key) {
        if(currentSize > 0){
            key = key % buckets.length;
            buckets[key] = -1;
            currentSize--;
        }
    }

}
