package questions.leetcode;

public class SortLL {

    public static ListNode sortList(ListNode head) {
        int len = 1;
        ListNode current = head;
        while (current.next!=null){
            len++;
            current =  current.next;
        }
        return divideAndMerge(head,0,len-1);
    }

    public static ListNode divideAndMerge(ListNode listNode,int start, int end){
        if(start == end){
            return listNode;
        }
        int mid = (start+end)/2;
        int startP = start;
        int midP = mid;
        ListNode rightStart = listNode;
        while(startP <= mid && rightStart!=null){
            startP++;
            rightStart = rightStart.next;
        }
        ListNode leftNode = divideAndMerge(listNode,start,mid);
        ListNode righNode = divideAndMerge(rightStart,mid+1,end);

        ListNode node = null;
        ListNode beg = null;
        midP = mid;
        startP = start;
        while (leftNode!=null && righNode!=null && start<=mid && mid+1<=end){
            if(leftNode.value > righNode.value){
                if(node == null) {
                    node = new ListNode(righNode.value);
                    beg = node;
                }
                else {
                    node.next = new ListNode(righNode.value);
                    node = node.next;
                }
                righNode = righNode.next;
                mid++;
            }
            else {
                if(node == null) {
                    node = new ListNode(leftNode.value);
                    beg = node;
                }
                else {
                    node.next = new ListNode(leftNode.value);
                    node = node.next;
                }
                leftNode = leftNode.next;
                start++;
            }
        }

        while (leftNode!=null && start<=midP){
            if(node == null){
                node = new ListNode(leftNode.value);
                beg = node;
            }else{
                node.next = new ListNode(leftNode.value);
                node = node.next;
            }
            leftNode = leftNode.next;
            start++;
        }

        while (righNode!=null && mid+1<=end){
            if(node == null){
                node = new ListNode(righNode.value);
                beg = node;
            }
            else {
                node.next = new ListNode(righNode.value);
                node = node.next;
            }
            righNode = righNode.next;
            mid++;
        }
        return beg;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
//        head.next.next.next = new ListNode(3);
//        head.next.next.next.next = new ListNode(-2);
//        head.next.next.next.next.next = new ListNode(6);
       head = sortList(head);
        while (head!=null){
            System.out.println(head.value);
            head = head.next;
        }
    }

}
