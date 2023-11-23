class conversion{
    public static String convert(String s, int numRows){
        if(numRows == 1){return s;}
        String[] strings = new String[numRows];
        String output = "";
        boolean zag = false;
        int j = 0;

        for(int i = 0; i < numRows; i++){
            strings[i] = "";
        }

        for(int i = 0; i < s.length(); i++){
            strings[j] += s.charAt(i);

            if(zag){
                if(j == 0){
                    zag = false;
                    j++;
                }
                else{
                    j--;
                }
            }
            else{
                if(j == numRows - 1){
                    zag = true;
                    j--;
                }
                else{
                    j++;
                }
            }
        }
        
        for(int i = 0; i < numRows; i++){
            output += strings[i];
        }

        return output;
    }

    public static void main(String[] args){
        String input = "PAYPALISHIRING";
        System.out.println(convert(input, 3));
    }
}