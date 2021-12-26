package questions.leetcode;


public class KthLargestElementArray {

    public static void main(String[] args) {
        int k = 4;
        int [] nums ={3,2,3,1,2,4,5,5,6};
        if(nums.length == 0 || nums.length < k){
            return;
        }
        else{
            System.out.println(findKthSmallest(nums,0,nums.length-1,k));
        }
    }

    public static int findKthSmallest(int[]nums,int p,int q,int k){
        int pos = findPosition(nums,p,q);
        if(pos == k){
            return nums[pos-1];
        }
        else{
            if(pos > k){
               return findKthSmallest(nums,p,pos-2,k);
            }else{
               return findKthSmallest(nums,pos,q,k);
            }
        }
    }

    public static int findPosition(int [] nums,int p,int q){
        int elm = nums[p];
        int i = p;
        for(int j = p+1;j<=q;j++){
            if(nums[j] >= elm){
                i++;
                swap(nums,i,j);
            }
        }
        swap(nums,i,p);
        return i+1;
    }

    public static void swap(int[]arr,int i,int j){
        int tempVar = arr[i];
        arr[i] = arr[j];
        arr[j]=tempVar;
    }
}
