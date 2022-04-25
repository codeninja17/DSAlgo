package questions.leetcode;

import datastructures.TreeNode;

/**
 * 112. Path Sum
 */
public class PathSum {

    public static boolean hasPathSum(TreeNode root, int targetSum) {

        return checkSum(root,targetSum);
    }

    public static boolean checkSum(TreeNode root,int targetSum){
        if(root == null){
           return false;
        }
        if(root.val == targetSum && root.left == null && root.right == null) return true;
        return checkSum(root.left,targetSum-root.val)  || checkSum(root.right,targetSum-root.val);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTreeNode();
        System.out.println(hasPathSum(treeNode,23));
    }
}
