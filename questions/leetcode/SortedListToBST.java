package questions.leetcode;

import datastructures.TreeNode;

/**
 * 109. Convert Sorted List to Binary Search Tree
 */
public class SortedListToBST {

    public static TreeNode sortedListToBST(ListNode head) {
        int i = 0;
        ListNode start = head;
        while(start!=null){
            start = start.next;
            i++;
        }
        return findNode(0,i-1,head);
    }

    public static TreeNode findNode(int start , int  end , ListNode startNode){
        if(start > end){
            return null;
        }
        TreeNode node = new TreeNode();
        int mid = (end+start)/2;
        int i = start;
        ListNode sNode = startNode;
        while(sNode!=null && i < mid){
            sNode = sNode.next;
            i++;
        }
        if(sNode!=null) {
            System.out.println("Mid Node is :" + sNode.value);
            node.val = sNode.value;
        }
        node.left = findNode(start,mid-1,startNode);
        node.right = findNode(mid+1,end,sNode == null ? null : sNode.next);
        return node;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println(sortedListToBST(head));


    }

}
