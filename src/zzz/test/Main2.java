package zzz.test;

public class Main2 {
    public static void main(String[] args){
        String a = "partition0_chunk0.txt";
        String aLeft="", aRight="";
        for(int i = a.length()-1; i>= 0; i--){
            if(a.charAt(i) == '_'){
                aLeft = a.substring(0, i);
                aRight = a.substring(i+1);
                break;
            }
        }
        System.out.println(aLeft);
        System.out.println(aRight);
    }
}
