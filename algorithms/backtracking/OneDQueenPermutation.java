package algorithms.backtracking;

import java.util.Arrays;

public class OneDQueenPermutation {


    public static void queenPermutation(boolean [] boxes,int qpsf , int tq , String ans){
        if(qpsf == 2){
            System.out.print(ans + ", ");
            return;
        }
        for(int i = 0 ; i < boxes.length;i++){
            if(!boxes[i]){
              boxes[i] = true;
              queenPermutation(boxes,qpsf+1,tq,ans + "q"+qpsf+"b"+i);
              boxes[i] = false;
            }
        }
    }

    public static void queenCombination(boolean [] boxes,int qpsf , int tq , String ans){
        if(qpsf == 2){
            System.out.print(ans + ", ");
            return;
        }
        for(int i = 0 ; i < boxes.length;i++){
            if(!boxes[i]){
                boxes[i] = true;
                queenPermutation(boxes,qpsf+1,tq,ans + "q"+qpsf+"b"+i);
            }
        }
    }


    public static void main(String[] args) {
        boolean [] boxes = new boolean[4];
        Arrays.fill(boxes,false);
        OneDQueenPermutation.queenPermutation(boxes,0,2,"");
        System.out.println();
        OneDQueenPermutation.queenCombination(boxes,0,2,"");
    }

}
