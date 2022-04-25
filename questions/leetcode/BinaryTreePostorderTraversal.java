package questions.leetcode;

import educative.binarysearchtrees.BinarySearchTreeOps;
import educative.binarysearchtrees.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

    public static List<Integer> postorderTraversal(Node root) {
        List<Integer> integerList = new ArrayList<>();
        Stack<Node> stackTemp = new Stack<>();
        Stack<Node> integerStack = new Stack<>();
        while(true){
            if(root!=null){
                integerStack.push(root);
                root = root.getLeft();
            }else{
                if(!integerStack.empty()){
                    Node n = integerStack.peek();
                    if(!(!stackTemp.empty() && stackTemp.peek().equals(n)) && n.getRight()!=null){
                        stackTemp.push(n);
                        root = n.getRight();
                    }else{
                        if(!stackTemp.empty() && stackTemp.peek().equals(n)) stackTemp.pop();
                        integerList.add(integerStack.pop().getValue());
                    }
                }else {
                    break;
                }
            }
        }
        return integerList;
    }

    public static void main(String[] args) {
        BinarySearchTreeOps binarySearchTreeOps = BinarySearchTreeOps.createBinaryTree();
        System.out.println(postorderTraversal(binarySearchTreeOps.getRoot()));
    }

}
