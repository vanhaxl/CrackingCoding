package zzz.test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("partitionLast_trailer.txt");
        list.add("partition0_chunk0.txt");
        list.add("partition0_chunk1.txt");
        list.add("partition0_chunk200000.txt");
        list.add("partition1_chunk0.txt");
        list.add("partition10_chunk0.txt");
        list.add("partition10_chunk3.txt");
        list.add("partition10_chunk4.txt");
        list.add("partition100_chunk0.txt");
        list.add("partition100_chunk1.txt");
        list.add("partition10000_chunk2.txt");
        list.add("partition2_chunk0.txt");
        list.add("partition3_chunk0.txt");
        list.add("partition3_chunk1.txt");


        // sort fileNames list
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String aLeft = "", aRight = "";
                String bLeft = "", bRight = "";

                for (int i = a.length()-1; i >= 0; i--) {
                    if (a.charAt(i) == '_') {
                        aLeft = a.substring(0, i);
                        aRight = a.substring(i+1);
                        break;
                    }
                }

                for (int i = b.length()-1; i >= 0; i--) {
                    if (b.charAt(i) == '_') {
                        bLeft = b.substring(0, i);
                        bRight = b.substring(i+1);
                        break;
                    }
                }

                int compareLeft = compare2String(aLeft, bLeft);
                if(compareLeft != 0){
                    return compareLeft;
                } else{
                    return compare2String(aRight, bRight);
                }
            }
        };

        Collections.sort(list, comparator);
        System.out.println(list);

    }
    public static int compare2String(String a, String b){
        if (a.length() != b.length())
            return Integer.compare(a.length(), b.length());
        else
            return a.compareTo(b);
    }
}
