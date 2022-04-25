package questions.leetcode;


public class RemoveDuplicatesfromSortedList {


    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        while (current!=null){
            ListNode next = current.next;
            if(prev!=null && prev.value == current.value){
                prev.next = next;
            }else {
                prev = current;
            }
            current = next;
        }
        return head;
    }
}
