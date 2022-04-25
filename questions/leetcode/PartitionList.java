package questions.leetcode;

/**
 * 86. Partition List
 */
public class PartitionList {

    public static ListNode partition(ListNode head, int x) {
        if(head == null|| head.next == null) return head;
        ListNode headCopy = head;
        ListNode firstList = null;
        ListNode firstListLastNode = null;

        ListNode secondList = null;
        ListNode secondListListNode = null;

        while(head!=null){
            if(head.value < x){
                if (firstList == null) {
                    firstList = head;
                    firstListLastNode = firstList;
                }
                else {
                    firstListLastNode.next = head;
                    firstListLastNode = firstListLastNode.next;
                }
            }else {
                if (secondList == null) {
                    secondList = head;
                    secondListListNode = secondList;
                }else {
                    secondList.next = head;
                    secondList = secondList.next;
                }
            }
            head = head.next;
        }
        if(secondList!=null) secondList.next =null;
        if(firstListLastNode!=null) firstListLastNode.next = secondListListNode;
        return firstList == null ? headCopy : firstList;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        ListNode result = partition(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }

}
