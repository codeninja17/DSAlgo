package questions.leetcode;

public class SwpNodesInPairs {


    public static ListNode swapPairs(ListNode head) {
        int k = 1;
        ListNode headCopy = null;
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while (current!=null){
            while(current!=null && k<=2){
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                k++;
            }
            if(prev!=null && prev.next!=null){
                if(current!=null && current.next!=null) prev.next.next = current.next;
                else prev.next.next = current;
            }
            if(headCopy == null) headCopy = prev;
            prev = null;
            k = 1;
        }
        return headCopy == null ? head : headCopy;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
       // head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = swapPairs(head);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }



}
