package questions.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 350. Intersection of Two Arrays II
 */
public class IntersectionOfArrays2 {

    public int[] intersect(int[] nums1, int[] nums2) {
        final Map<Integer,Integer> integers = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        if(nums1.length > nums2.length){
            Arrays.stream(nums2).forEach(value ->{
                int count = integers.getOrDefault(value,0);
                integers.put(value,count+1);
            });
            findIntersection(integers,nums1,result);
        }else {
            Arrays.stream(nums1).forEach(value ->{
                int count = integers.getOrDefault(value,0);
                integers.put(value,count+1);
            });
            findIntersection(integers,nums2,result);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private void findIntersection(Map<Integer,Integer> integers, int [] nums,List<Integer> result){
        Arrays.stream(nums).forEach(value -> {
            if(integers.containsKey(value)){
                int count = integers.get(value);
                if(count > 0){
                    result.add(value);
                    integers.put(value,count-1);
                }
            }
        });
    }

    public static void main(String[] args) {
        int [] nums1 = {1,1,1};
        int [] nums2 = {1,1};
        IntersectionOfArrays2 i = new IntersectionOfArrays2();
        System.out.println(Arrays.toString(i.intersect(nums1,nums2)));
    }

}
