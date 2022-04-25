package questions.leetcode;

import datastructures.TreeNode;

/**
 * 114. Flatten Binary Tree to Linked List
 */
public class FlattenBinaryTreeLinkedList {

    public static void flatten(TreeNode root) {
        flattenNodes(root);
    }

    public static TreeNode flattenNodes(TreeNode node){
        if(node!=null && node.left == null && node.right == null) return node;
        if(node!=null){
            TreeNode left = flattenNodes(node.left);
            TreeNode right = flattenNodes(node.right);
            if(left!=null){
                TreeNode leftEnd = left;
                while(leftEnd.right != null) leftEnd = leftEnd.right;
                node.right = left;
                node.left = null;
                leftEnd.right = right;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        flatten(root);
        int x = 1;
    }
}
