package questions.leetcode;

import educative.binarysearchtrees.BinarySearchTreeOps;
import educative.binarysearchtrees.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {

    public static List<Integer> preOrderTraversal(Node root) {
        List<Integer> integerList = new ArrayList<>();
        Stack<Node> integerStack = new Stack<>();
        while(true){
            if(root!=null){
                integerStack.push(root);
                integerList.add(root.getValue());
                root = root.getLeft();
            }else{
                if(!integerStack.empty()){
                    Node n = integerStack.pop();
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
        System.out.println(preOrderTraversal(binarySearchTreeOps.getRoot()));
    }

}
