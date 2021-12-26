package educative.binarysearchtrees;

public class HeightOfABST {

    int findHeight(Node root){
        if(root == null){
            return -1;
        }
        return 1 + Math.max(findHeight(root.getLeft()),findHeight(root.getRight()));

    }

    public static void main(String[] args) {
        BinarySearchTreeOps binarySearchTreeOps = BinarySearchTreeOps.createBinaryTree();
        HeightOfABST heightOfABST = new HeightOfABST();
        System.out.println(heightOfABST.findHeight(binarySearchTreeOps.getRoot()));

    }
}
