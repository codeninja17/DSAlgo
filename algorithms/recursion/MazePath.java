package algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

public class MazePath {

    public List<String> getMazePath(int cr , int cc , int er , int ec){
        if( cr == er && cc == ec){
            List<String> baseCaseRes = new ArrayList<>();
            baseCaseRes.add("");
            return baseCaseRes;
        }

        List<String> resultList = new ArrayList<>();
        if(ec > cc){
            List<String> recResult = getMazePath(cr,cc+1,er,ec);
            for(String recR : recResult){
                resultList.add("H" + recR);
            }
        }
        if(er > cr){
            List<String> recResult = getMazePath(cr+1,cc,er,ec);
            for(String recR : recResult){
                resultList.add("V" + recR);
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        MazePath mazePath = new MazePath();
        System.out.println(mazePath.getMazePath(0,0,2,2));
    }

}
