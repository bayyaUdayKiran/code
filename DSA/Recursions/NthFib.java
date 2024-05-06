public class NthFib{
    public static void main(String[] args) {
        System.out.println(fib(5));
        
    }

    public static int fib(int n){
        if(n<=1){
            return n;
        }
        return fib(n-1) + fib(n-2); // Here at every recursion the fib function tries to know the number's value at that particular location. And it goes on until it hits a base case, and when it does it recursively trace-backs and finds the values of the numbers from starting and finally finds the last number's value(i.e, nth number) in the series..
    }
}