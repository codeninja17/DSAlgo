package algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

public class DicePermutationBoardPath {

    public List<String> getPath(int target,int currentSum){

        if(currentSum == target){
            List<String> baseResultList = new ArrayList<>();
            baseResultList.add("");
            return baseResultList;
        }

        if(currentSum > target){
            return new ArrayList<>();
        }

        List<String> masterResult = new ArrayList<>();
        for(int i = 1; i<=6 ;i++){
            List<String> resultList = getPath(target,currentSum + i);
            for(String str : resultList){
                masterResult.add(i + str);
            }
        }
        return masterResult;

    }

    public static void main(String[] args) {
        DicePermutationBoardPath dicePermutationBoardPath = new DicePermutationBoardPath();
        System.out.println(dicePermutationBoardPath.getPath(10,0));
    }

}
