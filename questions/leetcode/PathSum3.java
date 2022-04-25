package questions.leetcode;

import datastructures.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class PathSum3 {


    public static int pathSum(TreeNode root, int targetSum) {
        return findPaths(root,targetSum,new ArrayList<>());
    }

    public static int findPaths(TreeNode root,int targetSum , List<Integer> currRes){
        if(root == null){
            return 0;
        }
        currRes.add(root.val);
       int count=0; int pathSum = 0;
       ListIterator<Integer> pathIterator = currRes.listIterator(currRes.size());
        while (pathIterator.hasPrevious()) {
            pathSum += pathIterator.previous();
            if (pathSum == targetSum) {
                count++;
            }
        }
        count+=findPaths(root.left,targetSum,currRes);
        count+=findPaths(root.right,targetSum,currRes);
        currRes.remove(currRes.size()-1);
        return count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + PathSum3.pathSum(root, 11));
    }

}
