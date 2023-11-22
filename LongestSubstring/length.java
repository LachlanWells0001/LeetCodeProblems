import java.util.Arrays;

public class length {
    public static int lengthOfLongestSubstring(String s){
        int stringLength = s.length();
        int bestLength = 0;
        //ASCII is 0 -> 127 
        int[] charIndex = new int[128];
        //Unfortunately the default value of 0 will throw off the solution for cases such as " " 
        Arrays.fill(charIndex, -1);
        int left = 0, right =0;

        //O(n) loop
        for (; right < stringLength; right ++){
            char currentChar = s.charAt(right);
            //If seen before update left
            if(charIndex[currentChar] >= left){
                left = charIndex[currentChar] + 1;
            }
            charIndex[currentChar] = right;
            //Calculates end of each loop instead of when a duplicate is found to avoid an extra if each loop
            bestLength = Math.max(bestLength, right - left + 1);
        }

        return bestLength;
        }
    
    public static void main(String[] args){
        String input = "abcabcbb";
        int output = lengthOfLongestSubstring(input);

        System.out.println(output);
    }
}
