package leetcode.one_fifty;

public class A_11_ContainerWithMostWater {
    public static void main(String[] args) {
        int[] arr = new int[] {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }

    public static int maxArea(int[] height) {
        int l = 0, r = height.length-1;
        int max = 0;
        while(l<r){
            max = Math.max(max, Math.min(height[l], height[r]) * (r-l));
            if(height[l] < height[r]){
                l++;
            } else{
                r--;
            }
        }
        return max;
    }
}
