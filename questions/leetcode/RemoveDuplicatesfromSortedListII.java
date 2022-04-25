package questions.leetcode;

/**
 * Remove Duplicates from Sorted List II
 */
public class RemoveDuplicatesfromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current!=null) {
            ListNode next = current.next;
            int count = 0;
            while (next!=null && next.value == current.value) {
                next = next.next;
                count++;
            }
            if(count > 0){
                if(current == head){
                    head = next;
                }
                if(prev!=null) prev.next = next;
                current = next;
            }else {
                prev = current;
                current = next;
            }

        }

        return head;
    }
}

