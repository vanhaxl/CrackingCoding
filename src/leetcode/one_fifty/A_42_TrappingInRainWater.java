package leetcode.one_fifty;

public class A_42_TrappingInRainWater {
    public static void main(String[] args) {
        int[] arr = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(arr));
    }

    public static int trap(int[] height) {
        int l = 0, r = height.length-1;
        int max = 0;
        while (l < r) {
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
            if(height[l] < height[r]){
                l++;
            } else{
                r--;
            }
        }
        return max;

    }
}
