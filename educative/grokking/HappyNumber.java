package educative.grokking;

public class HappyNumber {

    public static boolean find(int num) {

        int sum_f = calculateSum(num);
        int sum_s = calculateSum(calculateSum(sum_f));

        while (true){
            sum_f = calculateSum(sum_f);
            sum_s = calculateSum(calculateSum(sum_s));
            if(sum_f == sum_s){
               return false;
            }
            else if(sum_f == 1 || sum_s == 1 ){
                return true;
            }
        }
    }

    static int calculateSum(int num){
        int sum = 0;
        while(num!=0){
            int n = num % 10;
            sum += n*n;
            num/=10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(HappyNumber.find(23));
        // System.out.println(HappyNumber.find(12));
    }

}
