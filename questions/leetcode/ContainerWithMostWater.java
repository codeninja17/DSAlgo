package questions.leetcode;

/**
 * Container With Most Water
 */
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int maxVol = Integer.MIN_VALUE;
        while(start<end){
            int vol = (end-start) * Math.min(height[start],height[end]);
            if(maxVol < vol) maxVol = vol;
            if (height[start] < height[end]) start++;
            else end--;
        }
        return maxVol;
    }

    public static void main(String[] args) {
        int [] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(ContainerWithMostWater.maxArea(height));
    }
}
