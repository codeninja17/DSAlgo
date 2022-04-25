package algorithms;

import datastructures.TreeNode;

public class MorrisAlgorithm {

    public static void printInorder(TreeNode root,int k){
        TreeNode current = root;
        while (current !=null){
            if(current.left == null){
                if(--k == 0) System.out.println(current.val);
                current = current.right;
            }
            else {
                TreeNode predecessor = current.left;
                while (predecessor.right!=null && predecessor.right!=current){
                    predecessor = predecessor.right;
                }
                if(predecessor.right == null){
                    predecessor.right = current;
                    current = current.left;
                }else {
                    predecessor.right = null;
                    if(--k == 0) System.out.println(current.val);
                    current = current.right;
                }
            }
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.right = new TreeNode(6);
        root.left.right.right = new TreeNode(8);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(-2);
        root.left.left.right = new TreeNode(2);
        root.left.left.right.left = new TreeNode(-1);
        root.right.right = new TreeNode(30);
        printInorder(root,5);

    }

}
