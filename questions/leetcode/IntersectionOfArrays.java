package questions.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 *349. Intersection of Two Arrays
 */
public class IntersectionOfArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> integers = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        if(nums1.length > nums2.length){
            integers = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
            findInterssection(integers,nums1,result);
        }else {
            integers = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
            findInterssection(integers,nums2,result);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private void findInterssection(Set<Integer> integers, int [] nums,List<Integer> result){
        Arrays.stream(nums).forEach(value -> {
            if(integers.contains(value)){
                result.add(value);
                integers.remove(value);
            }
        });
    }

    public static void main(String[] args) {
        int [] nums1 = {1,2,2,1};
        int [] nums2 = {2,2};
        IntersectionOfArrays intersectionOfArrays = new IntersectionOfArrays();
        System.out.println(Arrays.toString(intersectionOfArrays.intersection(nums1,nums2)));
    }
}
