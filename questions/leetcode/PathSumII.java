package questions.leetcode;

import datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. Path Sum II
 */
public class PathSumII {

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> currRes = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        checkPathSum(root,targetSum,currRes,res);
        return res;
    }

    public static void checkPathSum(TreeNode root,int targetSum,List<Integer> currRes,
                                                   List<List<Integer>> res){
        if(root == null){
            return;
        }
        currRes.add(root.val);
        if(root.val == targetSum && root.left == null && root.right == null) {

            res.add(List.copyOf(currRes));
        }
        checkPathSum(root.left,targetSum-root.val,currRes,res);
        checkPathSum(root.right,targetSum-root.val,currRes,res);
        currRes.remove(currRes.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTreeNode();
        System.out.println(pathSum(treeNode,2));
    }

}
