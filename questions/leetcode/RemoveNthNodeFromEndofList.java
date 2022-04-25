package questions.leetcode;

/**
 * 19. Remove Nth Node From End of List
 */
public class RemoveNthNodeFromEndofList {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode headCopy = head;
        ListNode node = head;
        while(n > 0 && node!=null){
            node = node.next;
            n--;
        }


        if(node == null){
            headCopy = head.next;
            return headCopy;
        }
        ListNode prev = null;
        while(node!=null){
            node = node.next;
            prev = head;
            head = head.next;
        }


        if(prev!=null && head!=null){
            prev.next = head.next;
        }

        return headCopy;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
        System.out.println(removeNthFromEnd(head,2));


    }

}
