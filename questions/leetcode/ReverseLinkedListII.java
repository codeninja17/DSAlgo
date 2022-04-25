package questions.leetcode;

/**
 * 92. Reverse Linked List II
 */
public class ReverseLinkedListII {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;
        ListNode current = head;
        ListNode prevStart = null;
        int currPointer = 1;
        while(currPointer < left && current!=null){
            prevStart = current;
            current = current.next;
            currPointer++;
        }

        ListNode prev = null;
        ListNode next = null;
        while (currPointer <= right && current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            currPointer++;
        }
        if(prevStart!=null && prevStart.next!=null){
            prevStart.next.next = current;
            prevStart.next = prev;
        }
        if(prevStart == null) {
            next = prev;
            while(next.next!=null) next=next.next;
            next.next = current;
            return prev;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        ListNode result = reverseBetween(head, 1, 2);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
