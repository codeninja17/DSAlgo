package questions.leetcode;

import java.util.Arrays;

/**
 * 34. Find First and Last Position
 */
public class FirstAndLastPosition {

    public int[] searchRange(int[] num, int target){
        if(num.length == 0)
            return new int[]{-1,-1};

        return search(num,target,0,num.length-1,new int[]{-1,-1});
    }

    public int[] search(int [] num , int target , int start , int end,int[] result){
        if((start==end || start > end )){
            if(num[start] == target){
                return findIRange(num,start,target);
            }
            return result;
        }
        int mid = (start+end)/2;
        if(num[mid] == target)
            return findIRange(num,mid,target);

        if(num[mid] > target)
            return search(num,target,start,mid,result);

        else if (num[mid] < target)
            return search(num,target,mid+1,end,result);

        return result;
    }

    public int [] findIRange(int[] num, int index, int target){
        if(num.length == 1 && num[0] == target){
            return new int[]{0,0};
        }
        int startIndex = index;
        int endIndex = index;
        int next = index+1;
        int previous = index-1;
        int[] result;
        while(next < num.length && num[next] == target){
            endIndex = next;
            next++;
        }

        while (previous > -1 && num[previous] == target){
            startIndex = previous;
            previous--;
        }

        return new int[]{startIndex,endIndex};

    }


    public static void main(String[] args) {
        int[] num = {1,2,3,4,6,6,7,7,7};
        FirstAndLastPosition firstAndLastPosition = new FirstAndLastPosition();
        System.out.println(Arrays.toString(firstAndLastPosition.searchRange(num,7)));
    }

}
