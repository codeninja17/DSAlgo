package questions.leetcode;

/**
 * 9. Palindrome Number
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int num = x;
        int sum = 0;

        int m = 1;
        while(x >= 10){
            m*=10;
            x/=10;
        }
        x = num;
        while(x!=0){
            int n = x % 10;
            sum+=n*m;
            x/=10;
            m/=10;
        }
        return sum == num;
    }

    public static void main(String[] args) {
        PalindromeNumber p = new PalindromeNumber();
        System.out.println(p.isPalindrome(0));
        System.out.println(p.isPalindrome(9));
        System.out.println(p.isPalindrome(919));
        System.out.println(p.isPalindrome(1234321));
        System.out.println(p.isPalindrome(5000000));
    }

}
