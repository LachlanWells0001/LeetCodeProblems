public class atoi {
    public static int myAtoi(String s){
        if (s == null || s.isEmpty()) {return 0;}

        int index = 0;
        int sign = 1;
        int result = 0;

        // Step 1: Ignore all leading Whitespace
        while (index < s.length() && Character.isWhitespace(s.charAt(index))) {
            index++;
        }

        // Look for Sign, because can only be here according to their spec
        if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = (s.charAt(index++) == '-') ? -1 : 1;
        }

        // Read digits until the next non-digit character or the end of the input
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            
            // Convert char to int directly
            int digit = s.charAt(index) - '0';  

            // Check for overflow
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        return result * sign;
    }
    
    public static void main(String[] args){
        String input = "4193 with words";
        System.out.println(myAtoi(input));
    }
}
