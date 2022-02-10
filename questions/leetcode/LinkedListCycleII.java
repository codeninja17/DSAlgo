package questions.leetcode;


/**
 *  142. Linked List Cycle 2
 */
public class LinkedListCycleII {

    public ListNode findCycleStart(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int cycleLength = 0;

        while (slow!=null && fast!=null && slow.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow ==  fast){
                cycleLength = calculateCyclicLength(slow);
                break;
            }
        }
        return findStartNode(head,cycleLength);
    }

    public int calculateCyclicLength(ListNode slow){
        int cycleLength = 0;
        ListNode currentNode = slow;
        do{
            currentNode = currentNode.next;
            cycleLength++;
        } while (currentNode!=slow);
            return cycleLength;
    }

    public ListNode findStartNode(ListNode head , int cycleLength){
        if(cycleLength > 0){
            ListNode pointer1 = head;
            ListNode pointer2 = head;

            while(cycleLength > 0){
                pointer2 = pointer2.next;
                cycleLength--;
            }

            while (pointer1!=pointer2){
                pointer1 = pointer1.next;
                pointer2=pointer2.next;
            }
            return pointer1;
        }
       return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        LinkedListCycleII linkedListCycleII = new LinkedListCycleII();

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + linkedListCycleII.findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + linkedListCycleII.findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + linkedListCycleII.findCycleStart(head).value);
    }
}

class ListNode {
    int value;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.value = val; }
    ListNode(int val, ListNode next) { this.value = val; this.next = next; }
}
