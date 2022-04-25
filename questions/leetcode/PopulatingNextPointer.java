package questions.leetcode;

import datastructures.TreeNode;

/*
116. Populating Next Right Pointers in Each Node
 */
public class PopulatingNextPointer {

    public TreeNode connect(TreeNode root) {
        TreeNode node = root;
        setSiblings(node);
        return root;
    }

    public void setSiblings(TreeNode root){
        if(root == null){
            return;
        }
        if(root.left!=null){
            root.left.next = root.right;
        }
        if(root.next!=null && root.right!=null) root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
    }


}
