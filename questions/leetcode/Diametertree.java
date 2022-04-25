package questions.leetcode;

import datastructures.TreeNode;

public class Diametertree {
     int diameter = 0;

    public  int diameterOfBinaryTree(TreeNode root) {
        findDiameter(root);
       return diameter;
    }

    public  int findDiameter(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null){
            return 1;
        }
        int leftCount = findDiameter(root.left);
        int rightCount = findDiameter(root.right);
        diameter = Math.max(diameter,leftCount+rightCount);
        return Math.max(leftCount,rightCount)+1;
    }


    public static void main(String[] args) {

    }

}
