package questions.leetcode;

import datastructures.TreeNode;

/**
 * 124. Binary Tree Maximum Path Sum
 */
public class BinaryTreeMaximumPathSum {

    private static int maxSum = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        findSum(root);
        return maxSum;
    }

    public static int findSum(TreeNode root){
        if(root == null)
            return 0;
        int leftSum = findSum(root.left);
        int rightSum = findSum(root.right);

        leftSum = Math.max(leftSum,0);
        rightSum = Math.max(rightSum,0);


        int currSum = leftSum + rightSum + root.val;
        maxSum = Math.max(maxSum,currSum);
        return Math.max(leftSum,rightSum) + root.val;
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
        System.out.println("Maximum Path Sum: " + maxPathSum(root));
    }
}
