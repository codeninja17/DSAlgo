package questions.leetcode;


import datastructures.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PathWithGivenSequence {

    public static boolean findPath(TreeNode root, int[] sequence) {

        return checkSequence(root,new ArrayList<>(), Arrays.stream(sequence).boxed().collect(Collectors.toList()));
    }

    public static boolean checkSequence(TreeNode root, List<Integer> currSeq ,List<Integer> sequence){
        if(root == null){
            return false;
        }
        currSeq.add(root.val);
        if(root.right == null && root.left == null){
            if(sequence.equals(currSeq)){
                return true;
            }
            currSeq.remove(currSeq.size()-1);
            return false;
        }
        boolean result = checkSequence(root.left,currSeq,sequence) || checkSequence(root.right,currSeq,sequence);
        currSeq.remove(currSeq.size()-1);
        return result;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
    }

}
