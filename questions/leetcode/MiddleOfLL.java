package questions.leetcode;

/**
 * 876. Middle of the Linked List
 */
public class MiddleOfLL {

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int count = 1;

        while (fast.next!=null){
            if(fast.next.next!=null){
                fast = fast.next.next;
                count+=2;
            }else {
                fast = fast.next;
                count++;
            }
        }
        int headNodeIdx = (count/2)+1;
        while (headNodeIdx > 1){
            head = head.next;
            headNodeIdx--;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println(middleNode(head));
    }

}


