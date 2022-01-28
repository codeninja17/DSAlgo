package questions.leetcode;

import java.util.Arrays;

public class MergeTwoSortedArrayInplace {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1 , p2 = n-1 , p3 = m+n-1;

        while(p1>=0 && p2>=0){
            if(nums1[p1] > nums2[p2]){
                nums1[p3--] = nums1[p1--];
            }
            else {
                nums1[p3--] = nums2[p2--];
            }
        }

        if(p3>=0){
            while(p2>=0){
                nums1[p3--] = nums2[p2--];
            }
            while(p1>=0){
                nums1[p3--] = nums1[p1--];
            }
        }

    }

    public static void main(String[] args) {
        int [] nums1 = {1,5,6,0,0,0,0,0,0};
        int [] nums2 = {2,3,4,7,8,9};
        MergeTwoSortedArrayInplace m = new MergeTwoSortedArrayInplace();
        m.merge(nums1,3,nums2,nums2.length);
        System.out.println(Arrays.toString(nums1));
    }

}
