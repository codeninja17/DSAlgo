package questions.leetcode;

import datastructures.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 501. Find Mode in Binary Search Tree
 */
public class ModesInBST {

    public static int[] findMode(TreeNode root) {
        Set<Integer> res = new HashSet<>();
        findAllModes(root,null,res,0);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int findAllModes(TreeNode root, TreeNode prev ,Set<Integer> resultList,int maxCount)
    {
        if(root == null) return maxCount;
        int count = 1;
        if(root.right!=null && root.val == root.right.val) {
            count++;
        }
        if(root.left!=null && root.val == root.left.val) {
            count++;
        }

        if (count > maxCount) {
            resultList.clear();
            resultList.add(root.val);
            maxCount = count;
        }else if(count == maxCount){
            resultList.add(root.val);
        }

        maxCount = findAllModes(root.left,root,resultList,maxCount);
        maxCount = findAllModes(root.right,root,resultList,maxCount);
        return maxCount;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTreeNode();
        System.out.println(Arrays.toString(findMode(treeNode)));


    }


}
