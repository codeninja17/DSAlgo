package questions.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private int capacity;
    private int size;
    private Map<Integer, Node> cache;
    private Map<Integer, Integer> keyToValue;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.cache = new HashMap<>();
        this.keyToValue = new HashMap<>();
    }

    public void put(int key, int value) {
        if(keyToValue.containsKey(key)) {
            Node node = cache.get(key);
            updateValue(key, value, node);
            removeNode(node);
            addToFront(node);
        }
        else{
            Node node = new Node(key, value);
            if(size >= capacity) {
                removeTail();
                size--;
            }
            keyToValue.put(key, value);
            cache.put(key, node);
            addToFront(node);
            size++;
        }
    }

    private void removeTail() {
        tail.getPrev().setNext(null);
        cache.remove(tail.getKey());
        keyToValue.remove(tail.getKey());
        tail = tail.getPrev();
    }

    private void removeNode(Node node) {
        if(head == node) {
            return;
        }
        if(tail == node) {
            tail = node.getPrev();
        }
        node.getPrev().setNext(node.getNext());
        if(node.getNext()!=null){
            node.getNext().setPrev(node.getPrev());
        }
    }

    private void updateValue(Integer key, Integer value, Node node) {
        keyToValue.put(key, value);
        node.setValue(value);
        cache.put(key, node);
    }

    public Integer get(int key) {
        if(keyToValue.containsKey(key)) {
            Node node = cache.get(key);
            removeNode(node);
            addToFront(node);
            return keyToValue.get(key);
        }
        return -1;
    }

    private void addToFront(Node node) {
        if(head!=null && head!=node) {
            node.setNext(head);
            head.setPrev(node);
        }

        head = node;
        if(tail == null) {
            tail =node;
        }
    }

    public static void main(String[] args) {

    }
}

class Node {
    private Integer key;
    private Integer value;
    private Node next;
    private Node prev;

    public Node(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
