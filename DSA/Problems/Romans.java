import java.util.*;

class Romans {
    public static int romanToInt(String input) {
       
        int ptr = 0;
        String keys = "IVXLCDM";
        int[] decimals = {1, 5, 10, 50, 100, 500, 1000};
        for (int i = input.length()-1; i>=0; i--){
            ptr += valueOf(input.charAt(i), keys, decimals);
            if(i!=0){
                if(valueOf(input.charAt(i-1), keys, decimals)<valueOf(input.charAt(i), keys, decimals)){
                    ptr-=valueOf(input.charAt(i-1), keys, decimals);
                    i-=1;
                }
            }
        }
        return ptr;

    }

    public static int valueOf(char k, String keys, int[] values){
        int iOfVal = keys.indexOf(k);
        return values[iOfVal];
    }

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.print("Input: ");
        String input = sc.nextLine();
        sc.close();
        System.out.println(romanToInt(input));

    }
}