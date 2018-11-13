package chapter1.array.and.string;

public class Q1_IsUnique {
    public static void main(String[] args){

    }

    public static boolean isUnique(String s){
        if(s.length() > 128) return  false;
        int size = 128;//ascii
        boolean [] arr = new boolean[size];
        for(int i = 0; i< s.length(); i++){
            int index = s.charAt(i);

        }

    }
}
