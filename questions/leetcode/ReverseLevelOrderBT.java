package questions.leetcode;

import datastructures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107. Binary Tree Level Order Traversal II
 */
public class ReverseLevelOrderBT {

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> res = new LinkedList<>();
        if(root==null) return res;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while(!nodes.isEmpty()){
            int currSize = nodes.size();
            List<Integer> currList = new ArrayList<>();
            while (currSize > 0){
                TreeNode currNode = nodes.remove();
                currList.add(currNode.val);
                if (currNode.left != null)
                    nodes.offer(currNode.left);
                if (currNode.right != null)
                    nodes.offer(currNode.right);
                currSize--;
            }
            res.add(0,currList);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTreeNode();
        System.out.println(levelOrderBottom(treeNode));
    }

}
