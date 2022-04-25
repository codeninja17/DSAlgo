package educative.binarysearchtrees;

public class NodesAtKHeight {

    private String res = "" ;

   public String findkNodes(Node root , int k) {
        if(k == 0 || root == null){
            if(root!=null){
                res =  res +root.getValue() +  ",";
            }
            return res;
        }
        k = k-1;
        findkNodes(root.getLeft(),k);
        findkNodes(root.getRight(),k);
        return res;
    }

    public static void main(String[] args) {
        BinarySearchTreeOps binarySearchTreeOps = BinarySearchTreeOps.createBinaryTree();

        NodesAtKHeight nodesAtKHeight = new NodesAtKHeight();
        System.out.println(nodesAtKHeight.findkNodes(binarySearchTreeOps.getRoot(),1));
        System.out.println(nodesAtKHeight.findkNodes(binarySearchTreeOps.getRoot(),3));
        System.out.println(nodesAtKHeight.findkNodes(binarySearchTreeOps.getRoot(),4));
        System.out.println(nodesAtKHeight.findkNodes(binarySearchTreeOps.getRoot(),15));
    }

}
