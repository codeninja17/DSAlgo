package questions.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 46. Permutations
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return List.of(new ArrayList<>());
        }
        List<List<Integer>> resultList = new ArrayList<>();
        int num = nums[0];
        int[] resArr = Arrays.copyOfRange(nums, 1, nums.length);
        List<List<Integer>> myRes = permute(resArr);
        for (List<Integer> myResList : myRes) {
            if (myResList.size() == 0) {
                resultList.add(List.of(num));
            } else {
                for (int i = 0; i <= myResList.size(); i++) {
                    List<Integer> concatList = new ArrayList<>();
                    Stream.of(myResList.subList(0, i), List.of(num)
                            , myResList.subList(i, myResList.size())).forEach(concatList::addAll);
                    resultList.add(concatList);
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> resultList = permutations.permute(nums);
        System.out.println(resultList);
    }

}
