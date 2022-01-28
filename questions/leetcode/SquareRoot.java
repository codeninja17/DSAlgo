package questions.leetcode;

/**
 * 69. Sqrt(x)
 */
public class SquareRoot {
    public int mySqrt(int x) {
        int l = 1 , h = x;
        int mid = 0;
        while(l <= h){
            mid = l + (h-l)/2;
            if(mid <= x / mid && (mid + 1) > x / (mid + 1)) return mid;
            else if(mid > x/mid){
                h = mid-1;
            }else if(mid < x/mid){
                l=mid+1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        SquareRoot squareRoot = new SquareRoot();
        System.out.println(squareRoot.mySqrt(625));
    }
}
