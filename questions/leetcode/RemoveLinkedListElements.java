package questions.leetcode;

/**
 * 203. Remove Linked List Elements
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode node = head;
        ListNode prev = null;
        while(node!=null){
            if(node.value == val){
                if(node == head){
                    head = node.next;
                }else {
                    prev.next = node.next;
                }
            }
            else{
                prev = node;
            }
            node = node.next;
        }
        return head;
    }
}
