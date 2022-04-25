package questions.leetcode;

import educative.binarysearchtrees.BinarySearchTreeOps;
import educative.binarysearchtrees.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal
 */
public class InorderTraversal {

    public static List<Integer> inorderTraversal(Node root) {
        List<Integer> integerList = new ArrayList<>();
        Stack<Node> integerStack = new Stack<>();
        while(true){
            if(root!=null){
                integerStack.push(root);
                root = root.getLeft();
            }else{
                if(!integerStack.empty()){
                    Node n = integerStack.pop();
                    integerList.add(n.getValue());
                    root = n.getRight();
                }else {
                    break;
                }
            }
        }
        return integerList;
    }

    public static void main(String[] args) {
        BinarySearchTreeOps binarySearchTreeOps = BinarySearchTreeOps.createBinaryTree();
        System.out.println(inorderTraversal(binarySearchTreeOps.getRoot()));
    }

}
