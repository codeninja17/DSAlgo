package questions.leetcode;

public class SwappingNodesLinkedList {

    public ListNode swapNodes(ListNode head, int k) {
        ListNode first;
        ListNode second;

        ListNode fast = head;
        ListNode slow = head;

        while(k > 1){
            fast = fast.next;
            k--;
        }

        first = fast;

        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        second = slow;

        int temp = second.value;
        second.value = first.value;
        first.value = second.value;
        return head;
    }

}
