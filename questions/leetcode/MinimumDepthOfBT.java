package questions.leetcode;

import datastructures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. Minimum Depth of Binary Tree
 */
public class MinimumDepthOfBT {

    public static int minDepth(TreeNode root) {
        int minDepth = 0;
        if(root == null) return minDepth;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()){
            int currSize = nodeQueue.size();
            minDepth++;
            while(currSize>0){
                TreeNode currNode = nodeQueue.remove();
                if(minDepth!=1 && (currNode.right == null && currNode.left == null)) return minDepth;
                if (currNode.left != null)
                    nodeQueue.offer(currNode.left);
                if (currNode.right != null)
                    nodeQueue.offer(currNode.right);
                currSize--;
            }
        }
        return minDepth;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTreeNode();
        System.out.println(minDepth(treeNode));
    }

}
