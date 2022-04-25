package questions.leetcode;

import datastructures.TreeNode;

public class LinkedListBinaryTree {

    public static boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null) return false;
        if(isSubPathPresent(head,root)) return true;
        return isSubPath(head,root.left) || isSubPath(head,root.right);
    }

    public static boolean isSubPathPresent(ListNode head, TreeNode root) {
        if(head == null) return true;
        if(root == null) return false;
        if(root.val != head.value)
            return false;
        return isSubPathPresent(head.next,root.left) || isSubPathPresent(head.next,root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
       //  root.left = new TreeNode(2);
        root.right = new TreeNode(1);
        // root.left.left = new TreeNode(1);
        // root.left.right = new TreeNode(2);
        // root.left.right.right = new TreeNode(6);
        // root.left.right.left = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(1);
       // root.right.right.right = new TreeNode(1);
       root.right.left.left = new TreeNode(9);
//        root.right.left.right = new TreeNode(2);
//        root.right.left.right.left = new TreeNode(1);
//        root.right.left.right.right = new TreeNode(8);

        ListNode head = new ListNode(1);
        head.next = new ListNode(10);
        // head.next.next = new ListNode(1);
      //  head.next.next.next = new ListNode(9);

        System.out.println(isSubPath(head,root));

    }

}
