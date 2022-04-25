package questions.leetcode;

import datastructures.TreeNode;

import java.util.LinkedList;

/**
 * 230. Kth Smallest Element in a BST
 */
public class KSmallestElementBST {

    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (true){
         while (root!=null){
             stack.push(root);
             root = root.left;
         }
         root = stack.pop();
         k--;
         if(k == 0) return root.val;
         root = root.right;
        }
    }



}
