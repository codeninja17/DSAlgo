package questions.leetcode;

import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> listHashMap = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedStr = String.valueOf(chars);
            List<String> res = listHashMap.getOrDefault(sortedStr, new ArrayList<>());
            res.add(s);
            listHashMap.put(sortedStr, res);
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String,List<String>> entry: listHashMap.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }

    public static void main(String[] args) {
        String[] arr ={"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(arr);
    }

}
