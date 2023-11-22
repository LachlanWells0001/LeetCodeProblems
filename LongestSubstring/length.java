import java.util.HashMap;

public class length {
    public static int lengthOfLongestSubstring(String s){
        if(s.length() == 0) return 0;

        HashMap<Character, Integer> charDict = new HashMap<>();
        int idx = 0;
        int curLength = 0;
        int bestLength = 1;

        while(idx < s.length()){

            char curChar = s.charAt(idx);

            if(charDict.get(curChar) != null){
                bestLength = Math.max(curLength, bestLength);
                idx = charDict.get(curChar) + 1;
                charDict.clear();
                curLength = 0;
            }
            else{
                charDict.put(curChar, idx);
                idx++;
                curLength++;
            }
        }
        bestLength = Math.max(curLength, bestLength);
        return bestLength;
        }
    
    public static void main(String[] args){
        String input = "abcabcbb";
        int output = lengthOfLongestSubstring(input);

        System.out.println(output);
    }
}
