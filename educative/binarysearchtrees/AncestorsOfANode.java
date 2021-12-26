package educative.binarysearchtrees;

public class AncestorsOfANode {

    String findAncestors(Node root , int k){
        String res = "";
        Node node = root;
        boolean found = false;
        while(node!=null){

            if(node.getValue() ==  k){
                return res;
            }
           else if(node.getValue() > k){
               res = res + node.getValue() + ",";
               node = node.getLeft();
            }
            else {
                res = res + node.getValue() + ",";
                node = node.getRight();
            }
        }
        return "" ;
    }

    public static void main(String[] args) {
        BinarySearchTreeOps binarySearchTreeOps = BinarySearchTreeOps.createBinaryTree();
        AncestorsOfANode ancestorsOfANode = new AncestorsOfANode();
        String res = ancestorsOfANode.findAncestors(binarySearchTreeOps.getRoot(),39);
        System.out.println(res.isEmpty() ? "Not Found" : res.subSequence(0,res.length()-1));
    }
}
