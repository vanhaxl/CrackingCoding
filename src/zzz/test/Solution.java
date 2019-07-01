package zzz.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public static void main(String[] args){
        List<Integer> list = pathInZigZagTree(8);
        for(int x: list){
            System.out.print(x + " ");
        }
    }
    public static List<Integer> pathInZigZagTree(int label) {
        int[] arr= new int[label];
        for(int i = 0; i< label ; i++){
            arr[i] = i+1;
        }
        swap(arr, label);
        int index = 0;
        for(int i = arr.length-1; i>=0; i--){
            if(arr[i] == label){
                index = i;
                break;
            }
        }
        List<Integer> listIndex = new LinkedList<>();
        listIndex.add(index);
        while(index != 0){
            index = (index -1)/2;
            listIndex.add(index);
        }
        Collections.reverse(listIndex);
        List<Integer> result = new ArrayList<>();
        for(int i: listIndex){
            result.add(arr[i]);
        }
        return result;

    }
    public static void swap(int[] arr, int label){
        for(int i = 0; Math.pow(2, i) < label; i+=2){
            reverse(arr, (int) Math.pow(2, i+1) -1, (int) Math.pow(2, i+2) -2);
        }
    }
    public static void reverse(int[] arr, int i, int j){
        while(j >= arr.length){
            j--;
        }
        while(i<j){
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++; j--;
        }
    }


}