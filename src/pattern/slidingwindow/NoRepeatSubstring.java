package pattern.slidingwindow;

public class NoRepeatSubstring {
    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabcBBb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
    }

    public static int findLength(String s){

        int result = 0;

        int[] charSet = new int[128];

        int windowStart = 0;

        for(int windowEnd = 0; windowEnd < s.length(); windowEnd ++){
            charSet[s.charAt(windowEnd)] ++;
            while(charSet[s.charAt(windowEnd)] > 1){
                charSet[s.charAt(windowStart)] --;
                windowStart ++;
            }
            result = Math.max(result, windowEnd - windowStart +1);
        }
        return result;
    }
}
