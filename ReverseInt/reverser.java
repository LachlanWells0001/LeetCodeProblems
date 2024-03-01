public class reverser {
    public static int reverse(int x){
        int reversed = 0;

        while (x != 0) {
            //Get Right Most Digit
            int digit = x % 10;

            //Remove Right Most Digit from X
            x /= 10;

            // Check for integer overflow
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            //Slide along and add digit
            reversed = reversed * 10 + digit;
        }

        return reversed;
    }    

    public static void main(String[] args){
        int input = -123;
        System.out.println(reverse(input));
    }
}
