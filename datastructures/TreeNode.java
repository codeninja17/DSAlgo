package datastructures;

public class TreeNode {

   public int val;
   public TreeNode left;
   public TreeNode right;
   public TreeNode next;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode() {

    }

    public static TreeNode getTreeNode(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);
        root.left.left.left = new TreeNode(0);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(1);
        return root;
    }
}
