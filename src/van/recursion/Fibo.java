package van.recursion;

public class Fibo {
    public static void main(String[] args) {
        System.out.println(fib(4));
    }

    public static int fib(int n) {
        if(n < 2) return n;
        int a = 0, b = 1;
        for(int i = 2; i<=n; i++){
            int tmp = a;
            a = b;
            b += tmp;
        }
        return b;
    }
}

/*
0 -> 0
1-> 1
2 -> 1
3 -> 2
 */