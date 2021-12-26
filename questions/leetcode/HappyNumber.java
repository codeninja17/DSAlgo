package questions.leetcode;

/**
 *  202 Happy Number
 */
public class HappyNumber {

    public boolean isHappy(int n) {

        int sum_pointer_1 = calculateSquareSum(n);
        int sum_pointer_2 = calculateSquareSum(calculateSquareSum(n));
        while(sum_pointer_2 != sum_pointer_1){
             sum_pointer_1 = calculateSquareSum(sum_pointer_1);
             sum_pointer_2 = calculateSquareSum(calculateSquareSum(sum_pointer_2));
        }
        return sum_pointer_1 == 1;
    }

    public int calculateSquareSum(int n){
        int sum = 0;
        while(n>0){
            int num = n % 10;
            sum+=num*num;
            n/=10;
        }
        return sum;
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.isHappy(19));

    }

}
