package questions.leetcode;

/**
 * 27. Remove Element
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int lp = 0;
        int rp = 0;
        while(rp<nums.length){
            if(nums[lp] == val || nums[lp] ==  -1){
                if(rp == lp || nums[rp] == val){
                    while(rp<nums.length && nums[rp] == val){
                        rp++;
                    }
                }
                if(rp < nums.length){
                    nums[lp] = nums[rp];
                    nums[rp] = -1;
                    lp++;
                    rp++;
                }
            }else{
                rp++;
                lp++;
            }
        }
        return lp;
    }

    public static void main(String[] args) {
        int [] arr = {0,0,0,0,0,0,0,0,0,0,0,0};
        RemoveElement r = new RemoveElement();
        System.out.println(r.removeElement(arr,0));
    }
}


