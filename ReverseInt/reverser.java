public class reverser {
    public static int reverse(int x){
        int sign = Integer.signum(x);

        if(sign == 0){return 0;}

        x = Math.abs(x);

        String s = Integer.toString(x);
        char[] chars = s.toCharArray();
        
        char[] output = new char[chars.length];
        int i = chars.length - 1;
        int j = 0;

        for(; i >= 0; i--){
            output[j] = chars[i];
            j++;
        }

        try{
            return (Integer.parseInt(new String(output)) * sign);
        }
        catch(Exception e){
            return 0;
        }
    }    

    public static void main(String[] args){
        int input = -123;
        System.out.println(reverse(input));
    }
}
