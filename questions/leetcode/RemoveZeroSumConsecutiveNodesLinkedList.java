package questions.leetcode;

import java.util.Stack;

public class RemoveZeroSumConsecutiveNodesLinkedList {

    public static ListNode removeZeroSumSublists(ListNode head) {
        Stack<ListNode> listNodeStack = new Stack<>();
        ListNode current = head;
        int sum = 0;
        while (current!=null){
            if(!listNodeStack.isEmpty() && (current.value+sum == 0 || current.value + listNodeStack.peek().value == 0 )){
                if(current.value+sum == 0){

                }
            }else {
                listNodeStack.push(current);
                current = current.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(-3);
        head.next.next.next.next = new ListNode(-2);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println();
        head = removeZeroSumSublists(head);
        while (head!=null){
            System.out.println(head.value);
            head = head.next;
        }
    }

}
