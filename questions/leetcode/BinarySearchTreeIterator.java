package questions.leetcode;


import datastructures.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 173. Binary Search Tree Iterator
 */
public class BinarySearchTreeIterator {

    private LinkedList<TreeNode> nodeStack ;

    public BinarySearchTreeIterator(TreeNode root) {
        nodeStack = new LinkedList<>();
        while(root!=null){
            nodeStack.push(root);
            root = root.left;
        }
    }

    public int next() {
        if(!nodeStack.isEmpty()){
            TreeNode node = nodeStack.pop();
            if(node.right!=null){
                TreeNode subTree = node.right;
                while (subTree!=null){
                    nodeStack.push(subTree);
                    subTree = subTree.left;
                }
            }
            return node.val;
        }
        return 0;
    }

    public boolean hasNext() {
        return !nodeStack.isEmpty();
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
        BinarySearchTreeIterator bstIter = new BinarySearchTreeIterator(root);
        while (bstIter.hasNext()){
            System.out.println(bstIter.next());
        }
    }
}
