package leetcode.a_1000_a_1050;

public class A_1003 {
    public static  void main(String[] args){
        String s = "abccba";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        if(s.equals("abc") || s.isEmpty()) return true;
        if(!s.contains("abc")){
            return false;
        }
        int start = s.indexOf("abc");
        String nextS = s.substring(0, start) + s.substring(start + 3, s.length());
        return isValid(nextS);

    }


}
