public class longpalindrome {
    //Implementation of the Manacher Algorithm
    public static String longestPalindrome(String str){
        //Modify String to have special characters between each character
        StringBuilder sb = new StringBuilder();
        sb.append("$");

        for (int i = 0; i < str.length(); i++){
            sb.append(str.charAt(i));
            sb.append("$");
        }

        String s = sb.toString();

        //Apply Algorithm

        //Array that stores palindrome lengths
        int[] p = new int[s.length()];
        int centre = 0, right = 0;

        for(int i = 1; i < s.length() - 1; i++){
            //Calculate Mirror Index
            int mirror = 2 * centre - i;

            //If I is in boundary use mirror

            if(i < right){
                p[i] = Math.min(right - i, p[mirror]);
            }

            //Expand the palindrome

            while (i + p[i] + 1 < s.length() && i - p[i] - 1 >= 0 && s.charAt(i + p[i] + 1) == s.charAt(i - p[i] - 1)) {  
                p[i]++;  
            }  
            // Update the Center and right boundary if the palindrome expands beyond the current boundary  
            if (i + p[i] > right) {  
                centre = i;  
                right = i + p[i];  
                }  
            } 

        //Find Longest Palindrome

        int maxLen = 0, centerIndex = 0;  
        for (int i = 1; i < p.length - 1; i++) {  
            if (p[i] > maxLen) {  
                maxLen = p[i];  
                centerIndex = i;  
            }
        }    
        // Calculate the start index of the longest palindrome in the original string  
        int startIndex = (centerIndex - maxLen) / 2;  
        return str.substring(startIndex, startIndex + maxLen); // Return the longest palindrome      
    }

    public static void main(String[] args){
        String input = "123babad123";
        System.out.println(longestPalindrome(input));
    }
}
