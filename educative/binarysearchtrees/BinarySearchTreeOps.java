package educative.binarysearchtrees;

import java.util.Objects;

public class BinarySearchTreeOps {

    private Node root;

    private BinarySearchTreeOps(Node root){
        this.root = root;
    }

    public void insertNode(Node node , Integer value){
        Node parent = node;
        // traverse to the leaf node
        while(node!=null){
            parent = node;
            if(node.getValue() > value){
                node = node.getLeft();
            }
            else {
                node = node.getRight();
            }
        }

        // insert the node at the right pos
        if(parent !=null){
            Node newNode = Node.createNode(value);
            if(parent.getValue() > value){
                parent.setLeft(newNode);
            }
            else {
                parent.setRight(newNode);
            }
        }

    }

    public Node searchNode(Integer value, Node node){
        Node foundNode = null;
        while(node!=null) {
            if(node.getValue().equals(value)) {
                foundNode = node;
                break;
            }
            else if(node.getValue() > value){
                node = node.getLeft();
            }else {
                node = node.getRight();
            }
        }
        return foundNode;
    }

    // inorder print
    public void InorderPrint(Node node){
        if(node ==  null){
            return;
        }
        InorderPrint(node.getLeft());
        System.out.println(node.getValue());
        InorderPrint(node.getRight());
    }

    public void deleteNode(Node root , Integer value){
        Node node = null;
        Node parent = root;
        while(root!=null) {
            if(root.getValue().equals(value))  {
                node = root;
                break;
            }
            else if(root.getValue() > value){
                parent = root;
                root = root.getLeft();
            }else {
                parent = root;
                root = root.getRight();
            }
        }

        if(node!=null){
            if(node.getLeft() ==  null  && node.getRight() == null){
               deleteAndSetParent(parent,node,null);
            }

            else if(node.getRight() !=  null && node.getLeft() != null){
                Node inOrderSuccessor = node;
                Node inOrderParent = node;
                Node rNode = node.getRight();
                while(rNode!=null){
                    inOrderParent = inOrderSuccessor;
                    inOrderSuccessor = rNode;
                    rNode = rNode.getLeft();
                }
                deleteAndSetParent(inOrderParent,inOrderSuccessor,null);
                deleteAndSetParent(parent,node,inOrderSuccessor);
                if(inOrderSuccessor!=null){
                    inOrderSuccessor.setLeft(node.getLeft());
                    inOrderSuccessor.setRight(node.getRight());
                }
            }

            else if(node.getLeft() ==  null){
                deleteAndSetParent(parent,node,node.getRight());
            }

            else{
               deleteAndSetParent(parent,node,node.getLeft());
            }
        }
    }

    public void deleteAndSetParent(Node parent , Node node, Node newNode){
        if(parent.getLeft()!= null &&  parent.getLeft().equals(node) ){
            parent.setLeft(newNode);
        }
        else{
            parent.setRight(newNode);
        }
    }

    public Node getRoot() {
        return root;
    }


    public static BinarySearchTreeOps createBinaryTree(){
        Node root = Node.createNode(10);
        BinarySearchTreeOps binarySearchTreeOps = new BinarySearchTreeOps(root);
        binarySearchTreeOps.insertNode(root,3);
        binarySearchTreeOps.insertNode(root,12);
        binarySearchTreeOps.insertNode(root,11);
        binarySearchTreeOps.insertNode(root,5);
        binarySearchTreeOps.insertNode(root,9);
        binarySearchTreeOps.insertNode(root,39);
        binarySearchTreeOps.insertNode(root,4);
        binarySearchTreeOps.insertNode(root,7);
        return binarySearchTreeOps;
    }

    public static void main(String[] args) {
        BinarySearchTreeOps binarySearchTreeOps = BinarySearchTreeOps.createBinaryTree();
        binarySearchTreeOps.InorderPrint(binarySearchTreeOps.root);

        Node node = binarySearchTreeOps.searchNode(39,binarySearchTreeOps.getRoot());
        System.out.println();
        System.out.println("Node found : " + node.getValue());

        binarySearchTreeOps.deleteNode(binarySearchTreeOps.getRoot(),12);
        binarySearchTreeOps.InorderPrint(binarySearchTreeOps.getRoot());
    }



}

class Node{

    private Integer value;
    private Node left;
    private Node right;

    private Node(){

    }

    public static Node createNode(Integer value){
        Node node = new Node();
        node.value = value;
        return node;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return value.equals(node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
