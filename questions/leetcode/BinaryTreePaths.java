package questions.leetcode;

import datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. Binary Tree Paths
 */
public class BinaryTreePaths {

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        findAllPaths(root,new ArrayList<>(),res);
        return res;
    }

    static void findAllPaths(TreeNode root,List<Integer> currRes,List<String> stringList){
        if(root == null){
            return;
        }
        currRes.add(root.val);

        if(root.left == null && root.right == null){
            StringBuilder stringBuilder = new StringBuilder();
            currRes.forEach(integer -> stringBuilder.append(integer).append("->"));
            stringList.add(stringBuilder.toString().substring(0,stringBuilder.length()-2));
        }

        findAllPaths(root.left,currRes,stringList);
        findAllPaths(root.right,currRes,stringList);
        currRes.remove(currRes.size()-1);

    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTreeNode();
        System.out.println(binaryTreePaths(treeNode));
    }
}
