package questions.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1282. Group the People Given the Group Size They Belong To
 */
public class PeopleGroup {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer,List<Integer>> integerListMap = new HashMap<>();
        for(int i = 0; i<groupSizes.length ;i++){
            List<Integer> list = integerListMap.computeIfAbsent(groupSizes[i],integer -> new ArrayList<>());
            list.add(i);
            if(list.size() == groupSizes[i]) {
                res.add(list);
                integerListMap.put(groupSizes[i], new ArrayList<>());
            }
        }
        return res;
    }

}
