package questions.leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {

    private int capacity;
    private Map<Integer, Integer> valueMap;
    private Map<Integer, DLLNode> nodeMap;
    private DLLNode head;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.valueMap = new HashMap<>();
        this.nodeMap = new HashMap<>();
    }

    public Integer get(Integer key) {
        if (!valueMap.containsKey(key)) {
            return -1;
        }
        increaseFrequency(key);
        return valueMap.get(key);
    }

    private void increaseFrequency(Integer key) {
        DLLNode node = nodeMap.get(key);
        DLLNode newNode = null;
        if(node.next!=null) {
            if(node.next.frequency == node.frequency + 1) {
                node.next.keys.add(key);
                newNode = node.next;
            }
            else {
                DLLNode dllNode = new DLLNode(node.frequency + 1);
                DLLNode next = node.next;
                next.prev = dllNode;
                node.next = dllNode;

                dllNode.prev = node;
                dllNode.next = next;
                dllNode.keys.add(key);
                newNode = dllNode;
            }
        } else {
            DLLNode dllNode = new DLLNode(node.frequency + 1);
            node.next = dllNode;
            dllNode.prev = node;
            dllNode.keys.add(key);
            newNode = dllNode;

        }
        nodeMap.remove(key);
        nodeMap.put(key, newNode);
        node.keys.remove(key);
        if(node.keys.size() == 0) {
            remove(node);
        }
    }

    public void put(Integer key, Integer value) {
        if (valueMap.containsKey(key)) {
            valueMap.put(key, value);
            increaseFrequency(key);

        } else {
            if (valueMap.size() >= capacity) {
                removeNodeWithLeastFrequency();
            }
            addToHead(key);
            valueMap.put(key, value);
        }
    }

    private void removeNodeWithLeastFrequency() {
        int old = -1;
        for(int n : head.keys) {
            old = n;
            break;
        }
        head.keys.remove(old);
        if(head.keys.size() == 0) {
            remove(head);
        }
        valueMap.remove(old);
        nodeMap.remove(old);
    }

    private void remove(DLLNode node) {
        if (node.prev == null) {
            head = node.next;
        } else {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
    }

    private void addToHead(Integer key) {
        if (head == null) {
            head = new DLLNode(0);

        } else {
            if (head.frequency > 0) {
                DLLNode node = new DLLNode(0);
                head.prev = node;
                node.next = head;
                head = node;

            }
        }
        head.keys.add(key);
        nodeMap.put(key, head);
    }

    public static void main(String[] args) {
        int mod = (int) 1e9+7;
        System.out.println(mod);
    }

}


class DLLNode {
    int frequency;
    DLLNode next;
    DLLNode prev;
    LinkedHashSet<Integer> keys;

    public DLLNode(int frequency) {
        this.frequency = frequency;
        this.keys = new LinkedHashSet<>();
    }
}
