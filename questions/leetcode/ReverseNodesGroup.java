package questions.leetcode;

/**\
 * 25. Reverse Nodes in k-Group
 */
public class ReverseNodesGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {

        int count = 0;
        ListNode headCopy = head;
        while(headCopy!=null){
            headCopy = headCopy.next;
            count++;
        }

        int cycles = count/k;

        ListNode start;
        ListNode current = head;
        ListNode prev = null;
        ListNode next;
        ListNode end = null;
        while (current!=null && cycles > 0){
            int i = 0;
            start = current;
            while(i<k && cycles>0 && current!=null){
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                if(end!=null){
                    end.next = prev;
                }
                i++;
            }
            if(headCopy == null){
                headCopy = prev;
            }
            prev = null;
            end = start;
            cycles--;
        }
        if(current!=null && end!=null){
            end.next = current;
        }

        return headCopy;
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

        ListNode result = reverseKGroup(head, 1);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
