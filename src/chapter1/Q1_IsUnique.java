package chapter1;

public class Q1_IsUnique {
    public static void main(String[] args){
        String a = "I am from Vietnam";
        System.out.println(isUnique(a));
        int x = 2;
        System.out.println(isUniqueChars("bcd"));
    }

    public static boolean isUnique(String s){
        if(s.length() > 128) return  false;
        int size = 128;//ascii
        boolean [] arr = new boolean[size];
        for(int i = 0; i< s.length(); i++){
            int index = s.charAt(i);
            if(arr[index] == true){
                return false;
            }
            arr[index] = true;
        }
        return true;
    }

    public static boolean isUniqueChars(String str){
        int checker= 0;
        for (int i= 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }
}
