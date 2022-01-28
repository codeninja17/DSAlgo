package questions.GFG;

// https://www.geeksforgeeks.org/counting-inversions/
public class CountInversionsInArray {

    private static int localInv = 0;

    public static int countInversions(int[] arr, int start , int mid, int end){
        // create two temp arrays
        int l = mid-start+1;
        int m = end-mid;
        int [] temp_array_first = new int[l];
        int [] temp_array_second = new int[m];

        if(temp_array_first.length == 1 && temp_array_second.length ==1){
            if(arr[start] > arr[end])
               localInv++;
        }

        // copy to temp array
        int i = 0;
        int s = start;
        while(s<=mid){
            temp_array_first[i++] = arr[s++];
        }
        int z = mid+1;
        int j=0;
        while (z<=end){
            temp_array_second[j++] = arr[z++];
        }

        int p = 0;
        int q = 0;
        int k = start;
        int sum = 0;
        while(p<l && q<m){
            if(temp_array_first[p] > temp_array_second[q]){
                sum = sum + (l - p);
                arr[k++] = temp_array_second[q++];
            }
            else{
                arr[k++] = temp_array_first[p++];
            }
        }

        while(p<l){
            arr[k++] = temp_array_first[p++];
        }

        while(q<m){
            arr[k++] = temp_array_second[q++];
        }

        return sum;
    }

    public static int divideArr(int[] arr,int start, int end){

        if(start == end || start > end){
            return 0;
        }

        int mid = start+(end-start)/2;
        int sum = divideArr(arr,start,mid) + divideArr(arr,mid+1,end);
        sum+=countInversions(arr,start,mid,end);
        return sum;
    }

    public static boolean isIdealPermutation(int[] nums) {
        int sum = divideArr(nums,0,nums.length-1);
        return sum == localInv;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 1, 9, 10, 0};
        System.out.println(isIdealPermutation(arr));
        System.out.println(localInv);
    }

}
