package questions.leetcode;

import datastructures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. Binary Tree Right Side View
 */
public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()){
            int currLevels = treeNodes.size();
            while(currLevels > 0){
                TreeNode node = treeNodes.remove();
                if(currLevels == 1) res.add(node.val);
                if (node.left != null)
                    treeNodes.offer(node.left);
                if (node.right != null)
                    treeNodes.offer(node.right);
                currLevels--;
            }

        }
        return res;
    }

}
