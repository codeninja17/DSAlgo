package questions.leetcode;

import datastructures.TreeNode;

import java.util.Stack;

/**
 *  98. Validate Binary Search Tree
 */
public class ValidateBinarySearchTree {

    public static boolean traverseBST(TreeNode root, Stack<Integer> integerStack,boolean res){
        if(root == null) return res;
        res = traverseBST(root.left,integerStack,res);
        if(!integerStack.empty() && integerStack.pop()>=root.val) {
            return false;
        }
        integerStack.push(root.val);
        return traverseBST(root.right,integerStack,res);
    }

    public static void main(String[] args) {
       TreeNode treeNode = TreeNode.getTreeNode();

        System.out.println(traverseBST(treeNode,new Stack<>(),true));
    }
}
