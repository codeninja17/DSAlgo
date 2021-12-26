package datastructures;

import java.util.Random;

/**
 *  Singly Linked List Operations Insertions at Front, End , Middle , Deletions at any index, Reversal of LL
 */

public class LinkedList {

    static Node reverseLinkedList(){
        Node parentNode = initList();
        System.out.print("Original List : ");
        printLinkedList(parentNode);
        Node currNode = parentNode;
        Node prev = null;
        Node next = currNode.getNext();
        while(next.getNext()!=null){
            next = currNode.getNext();
            currNode.setNext(prev);
            prev = currNode;
            currNode = next;
        }
        currNode.setNext(prev);
        parentNode = currNode;
        return parentNode;
    }

    static Node deleteAtAnyIndex(int index){
        Node parentNode = initList();
        Node next = parentNode;

        System.out.print("Original List : ");
        printLinkedList(parentNode);

        int index_count = 0;
        while(index_count <index){
            index_count++;
            next = next.getNext();
        }

        Node nextNodeAtIndex = next.getNext().getNext();
        next.setNext(nextNodeAtIndex);
        return parentNode;
    }

    static Node insertAtBeginning(){
        Node linkedList = initList();
        Node newNode = Node.getNode(233);
        newNode.setNext(linkedList);
        return newNode;
    }

    static Node insertAtIndex(int index){
        Node parentNode = initList();
        Node newNode = Node.getNode(235);
        Node next = parentNode;
        // traverse to the end
        int index_count = 0;
        while(index_count <= index){
            index_count++;
            next = next.getNext();
        }
        newNode.setNext(next.getNext());
        next.setNext(newNode);
        return parentNode;
    }

    static Node insertAtEnd(){
        Node parentNode = initList();
        Node newNode = Node.getNode(234);
        Node next = parentNode;
        // traverse to the end
        while(next.getNext()!=null){
            next = next.getNext();
        }
        next.setNext(newNode);
        return parentNode;
    }

    static Node initList(){
        Random random = new Random();
        Node prevNode = Node.getNode(1);
        Node parentNode = prevNode;
        for(int i=0; i<10; i++){
            Node node = Node.getNode(random.nextInt(50));
            prevNode.setNext(node);
            prevNode = node;
        }
        return parentNode;
    }

    static void printLinkedList(Node next){
        while(next.getNext()!=null){
            System.out.print(next.getValue()+ " ");
            next = next.getNext();
        }
        System.out.println(next.getValue());
    }

    public static void main(String[] args) {
        // Insert at beginning
        printLinkedList(insertAtBeginning());
        // insert at end
        printLinkedList(insertAtEnd());
        // insert at index 4
        printLinkedList(insertAtIndex(4));

        // delete at index 4
        printLinkedList(deleteAtAnyIndex(4));

        // linkedList reversal

        printLinkedList(reverseLinkedList());


    }

}

class Node{
    private Integer value;
    private Node next;

    public static Node getNode(Integer value){
        Node n = new Node();
        n.value = value;
        return n;
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
}
