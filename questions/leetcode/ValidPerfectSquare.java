package questions.leetcode;
/*
* 367. Valid Perfect Square
*/
public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        int start = 1;
        int end = num;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(mid * mid ==  num){
                return true;
            }
            else if( mid * mid > num)
                end = mid-1;
            else
                start = mid+1;
        }
        return false;
    }

    public static void main(String[] args) {
        ValidPerfectSquare validPerfectSquare = new ValidPerfectSquare();
        System.out.println(validPerfectSquare.isPerfectSquare(0));
    }
}
