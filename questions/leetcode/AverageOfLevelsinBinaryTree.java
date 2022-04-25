package questions.leetcode;

import datastructures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 637. Average of Levels in Binary Tree
 */
public class AverageOfLevelsinBinaryTree {

    public static List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        List<Double> res = new ArrayList<>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()){
            int size = nodeQueue.size();
            double sum = 0;
            for(int i = 0 ; i<size ; i++){
                TreeNode node = nodeQueue.remove();
                sum+=(double) node.val;
                if(node.left!=null){
                    nodeQueue.offer(node.left);
                }
                if(node.right!=null){
                    nodeQueue.offer(node.right);
                }
            }
            double avg = (double) sum/size;
            res.add(avg);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<Double> result = averageOfLevels(root);
        System.out.print("Level averages are: " + result);
    }

}
