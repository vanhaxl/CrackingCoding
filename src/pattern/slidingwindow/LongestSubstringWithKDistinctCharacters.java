package pattern.slidingwindow;

public class LongestSubstringWithKDistinctCharacters {
    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + findLength("cbbebi", 3));


    }

    public static int findLength(String s, int k){
        int[] char_set = new int[26];
        int count = 0;
        int result = 0;

        int windowStart = 0;
        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++){
            char c = s.charAt(windowEnd);
            char_set[c - 'a'] ++;
            if(char_set[c-'a'] == 1){
                count ++;
            }
            while(count > k){
                char_set[s.charAt(windowStart) - 'a'] --;
                if(char_set[s.charAt(windowStart) -'a'] == 0){
                    count --;
                }
                windowStart++; //slide window until count <= k

            }
            result = Math.max(result, windowEnd - windowStart + 1);
        }
        return result;
    }
}
