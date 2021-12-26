package educative.binarysearchtrees;

public class MinValueBinaryTree {

    private static int counter = 0;

    public int findMin(Node root){
       while(root.getLeft()!=null){
            root = root.getLeft();
        }
        return root.getValue();
    }

    public int kMaximumNumber(Node root , int k){


        return Integer.MAX_VALUE;
    }

    public void descendingOrderPrint(Node node){

        if(node == null){
            return;
        }

        descendingOrderPrint(node.getRight());
        System.out.println(node.getValue());
        descendingOrderPrint(node.getLeft());

    }

    public void findKthMax(Node node , int k){
        if(node ==  null){
            return;
        }

        findKthMax(node.getRight(),k);

        if(k!= counter){
            counter++;
        }
        if(k == counter) {
            System.out.println(node.getValue());
            return;
        }else{
            findKthMax(node.getLeft(),k);
        }
    }

    public static void main(String[] args) {

        BinarySearchTreeOps binarySearchTreeOps = BinarySearchTreeOps.createBinaryTree();

       // binarySearchTreeOps.InorderPrint(root);

        MinValueBinaryTree minValueBinaryTree = new MinValueBinaryTree();
       // minValueBinaryTree.descendingOrderPrint(root);
        minValueBinaryTree.findKthMax(binarySearchTreeOps.getRoot(),2);
        counter = 0;
    }

}
