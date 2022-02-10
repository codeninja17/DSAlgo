package questions.leetcode;

/**
 *
 */
public class PalindromeLinkedList {

    public static boolean isPalindrome(ListNode head) {
        ListNode midN = middleNode(head);
        ListNode midNode = midN;
        midNode.next = reverseArray(midNode);
        ListNode headNode = head;
        while (midNode.next!=null && headNode!=null){
            if(midNode.next.value != headNode.value){
                midN.next = reverseArray(midN);
                return false;
            }
            midNode=midNode.next;
            headNode = headNode.next;
        }
        midN.next = reverseArray(midN);
        return true;
    }

    public static ListNode reverseArray(ListNode node){
        ListNode currNode = node.next;
        ListNode nextNode;
        ListNode prev = null;
        while (currNode!=null && currNode.next != null) {
            nextNode = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = nextNode;
        }
        if(currNode!=null){
            currNode.next = prev;
        }
        return currNode;
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int count = 1;

        while (fast.next!=null){
            if(fast.next.next!=null){
                fast = fast.next.next;
                count+=2;
            }else {
                fast = fast.next;
                count++;
            }
        }
        int headNodeIdx = 0;
        if(count % 2 == 0)
          headNodeIdx = (count/2);
        else headNodeIdx = (count/2)+1;
        while (headNodeIdx > 1){
            head = head.next;
            headNodeIdx--;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));
    }

}
