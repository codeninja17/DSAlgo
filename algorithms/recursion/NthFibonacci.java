package algorithms.recursion;

public class NthFibonacci {

    private Integer [] fib;

    NthFibonacci(int n){
        fib = new Integer[n];
    }

    public int fibonacciTerm(int n){
        if(n == 1){
            return 1;
        }
        if(n == 0){
            return 0;
        }

        int num1 = 0;
        if(fib[n-1] == null){
           num1 =  fibonacciTerm(n-1) ;
        }
        else{
            num1 = fib[n-1];
        }

        int num2 = 0;
        if(fib[n-2] == null){
            num2 = fibonacciTerm(n-2);
        }
        else{
            num2 = fib[n-2];
        }

        int sum = num1 + num2;
        fib[n] = sum;
        return sum;
    }

    public int powerOfANumber(int x,int n){
        if( n == 0){
            return 1;
        }
        return x * powerOfANumber(x,n-1);
    }

    public static void main(String[] args) {
        NthFibonacci nthFibonacci = new NthFibonacci(20);
        for(int i = 0 ; i < 20 ; i++)
            System.out.print(nthFibonacci.fibonacciTerm(i) + ", ");

        System.out.println(nthFibonacci.powerOfANumber(3,4 ));
    }

}
