package leetcode.a_1000_a_1050;

public class A_1004 {
    public static  void main(String[] args){
        int[] arr ={1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(longestOnes(arr, 2));
    }

    public static int longestOnes(int[] arr, int k) {
        int left = 0, right = 0;
        int max = 0;
        int countZero = 0;
        while(right < arr.length){
            if(arr[right] == 1){
                max = Math.max(max, right -left +1);
            } else{
                countZero ++;
                while(left <= right && countZero > k){
                    if(arr[left] == 0){
                        countZero--;
                    }
                    left ++;
                }
            }
            right ++;
        }
        max = Math.max(max, right -left);
        return max;
    }

}
