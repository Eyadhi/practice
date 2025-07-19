package dynamic_programming;

public class fibonaci {
    public static int fibonacci(int n) {
        int[] fib = new int[n];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n - 1];
    }

    public static int[] fibonacci1(int n) {
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }

    public static void main(String[] args) {
        int n = 10;
        int result = fibonacci(n);
        System.out.println("The " + n + "th Fibonacci number is: " + result);
        int[] res = new int[n];
        res = fibonacci1(n);
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
    }
}