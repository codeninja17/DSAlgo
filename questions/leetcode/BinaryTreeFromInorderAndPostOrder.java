package questions.leetcode;

import datastructures.TreeNode;

import java.util.HashMap;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 */
public class BinaryTreeFromInorderAndPostOrder {

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> integerHashMap = new HashMap<>();
        for(int i = 0;i<inorder.length;i++){
            integerHashMap.put(inorder[i],i);
        }
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        TreeNode current = root;
        for(int i = postorder.length-2;i>=0;i--){
            int indexCurrent = integerHashMap.get(current.val);
            int indexNext = integerHashMap.get(postorder[i]);

            while ((indexNext > indexCurrent && current.right!=null) || (indexNext < indexCurrent && current.left!=null)) {
                if (indexNext > indexCurrent) {
                    current = current.right;
                    indexCurrent = integerHashMap.get(current.val);
                }
                else {
                    current = current.left;
                    indexCurrent = integerHashMap.get(current.val);
                }
            }


            if (indexNext > indexCurrent) {
                current.right = new TreeNode(postorder[i]);
                current = root;
                continue;
            }
            else if(indexNext < indexCurrent){
                current.left = new TreeNode(postorder[i]);
                current = root;
                continue;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int [] inorder = {1,2,3,4};
        int [] postorder = {3,2,1,4};
        TreeNode root = buildTree(inorder,postorder);
        System.out.println(root);

    }

}
