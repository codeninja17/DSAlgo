package algorithms.recursion;

public class FactorialOfANumber {

    public long factorial(long n){
        if(n == 1)
            return n;
        return n * factorial(n-1);
    }

    public static void main(String[] args) {
        FactorialOfANumber factorialOfANumber = new FactorialOfANumber();
        System.out.println(factorialOfANumber.factorial(5));
    }

}
