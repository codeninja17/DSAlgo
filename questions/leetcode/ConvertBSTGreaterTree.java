package questions.leetcode;

import datastructures.TreeNode;

public class ConvertBSTGreaterTree {

    public static TreeNode convertBST(TreeNode root) {

        if(root!=null && root.right==null && root.left==null){
            return root;
        }
        TreeNode rightNode = convertBST(root.right);
        root.val += rightNode.val;
        if(root.left!=null) {
            root.left.val = root.val;
        }
        TreeNode leftNode = convertBST(root.left);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        TreeNode res = convertBST(root);

    }
}
