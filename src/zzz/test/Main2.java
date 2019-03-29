package zzz.test;

public class Main2 {
    //ttest branch
    public static void main(String[] args) {
        for(int i = 1; i<= 100; i++){
            if(checkPrime(i)){
                System.out.println(i);
            }
        }
    }

    public static boolean checkPrime(int n) {
        if (n <= 3) return true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i != 0) {
                return false;
            }
        }
        return true;
    }
}
