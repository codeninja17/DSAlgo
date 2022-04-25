package questions.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. Combination Sum
 */
public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        findCombinations(candidates,target,new ArrayList<>(),res,0);
        return res;
    }

    public static void findCombinations(int [] candidates,int target,List<Integer> currRes,List<List<Integer>> resultList,int currIndex){
        if(target <= 0){
            if(target == 0){
                resultList.add(List.copyOf(currRes));
            }
            return;
        }
        for(int i = currIndex ; i < candidates.length;i++){
            currRes.add(candidates[i]);
            findCombinations(candidates,target-candidates[i],currRes,resultList,i);
            currRes.remove(currRes.size()-1);
        }
    }

    public static void main(String[] args) {
        int [] arr = {2,3,6,7};
        System.out.println(combinationSum(arr,7));
        System.out.println();
    }

}
