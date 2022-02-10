package questions.leetcode;

/**
 * 143. Reorder List
 */
public class ReorderAList {

    public static void reorderList(ListNode head) {
        ListNode herac = head;
        ListNode midN = middleNode(head);
        midN.next = reverseArray(midN);
        ListNode midNext = midN.next;
        ListNode next = head.next;
        while (midN.next != null) {
            midN.next = midNext.next;
            next = head.next;
            head.next = midNext;
            midNext.next = next;
            head = next;
            midNext = midN.next;
        }
       head = herac;
    }

    public static ListNode reverseArray(ListNode node){
        ListNode currNode = node.next;
        ListNode nextNode;
        ListNode prev = null;
        while (currNode!=null && currNode.next != null) {
            nextNode = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = nextNode;
        }
        if(currNode!=null){
            currNode.next = prev;
        }
        return currNode;
    }

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
        int headNodeIdx =(count/2)+1;
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
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        reorderList(head);
    }

}
