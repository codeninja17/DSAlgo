package questions.leetcode;

import datastructures.TreeNode;

import java.time.temporal.Temporal;

/**
 * 129. Sum Root to Leaf Numbers
 */
public class SumRoottoLeafNumbers {

    public static int sumNumbers(TreeNode root) {
      return calculateSum(root,"",0);
    }

    public static int calculateSum(TreeNode root, String currRes, Integer res){
        if(root ==  null){
            return res;
        }

        currRes = currRes + root.val;
        if(root.left == null && root.right == null){
            return res+Integer.parseInt(currRes);
        }
        res += calculateSum(root.left,currRes,res) + calculateSum(root.right,currRes,res);
        currRes = currRes.substring(0,currRes.length());
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTreeNode();
        System.out.println(sumNumbers(treeNode));

    }

}
