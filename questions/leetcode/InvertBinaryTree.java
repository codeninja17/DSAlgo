package questions.leetcode;

import datastructures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 226. Invert Binary Tree
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);
        while (!treeNodeQueue.isEmpty()){
            int size = treeNodeQueue.size();
            for(int i = 0;i<size;i++){
                TreeNode node = treeNodeQueue.remove();
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
                if(node.right!=null){
                    treeNodeQueue.offer(node.right);
                }
                if(node.left!=null){
                    treeNodeQueue.offer(node.left);
                }
            }
        }
        return root;
    }

}
