package questions.leetcode;

import datastructures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrder {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()){
            List<Integer> currRes = new ArrayList<>();
            int currLevels = treeNodes.size();
            while(currLevels > 0){
                TreeNode node = treeNodes.remove();
                currRes.add(node.val);
                if (node.left != null)
                    treeNodes.offer(node.left);
                if (node.right != null)
                    treeNodes.offer(node.right);
                currLevels--;
            }
            res.add(currRes);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTreeNode();
        System.out.println(levelOrder(treeNode));
    }

}
