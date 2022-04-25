package questions.leetcode;

/**
 * 61 Rotate List
 */
public class RotateList {

    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        int len = 1;
        ListNode node = head;
        while(node.next!=null){
            len++;
            node=node.next;
        }

        int totalRotations = k%len;
        int curr = len-totalRotations;
        ListNode listNode = head;
        while(curr > 1){
            listNode = listNode.next;
            curr--;
        }
        node.next = head;
        head = listNode.next;
        listNode.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
        System.out.println(rotateRight(head,4));
    }

}


