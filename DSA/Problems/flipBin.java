import java.util.*;

public class flipBin {
    public static int minFlipsMonoIncr(String s) {
        boolean state = false;
        int oneCount = 0, flipCount = 0;
        for(int i = 0; i<s.length(); i++){
            if(state){
                if(s.charAt(i) == 0){
                    flipCount++;
                }else{
                    state = false;
                }
            }
            if(s.charAt(i) == '1'){
                oneCount++;
                state = true;
            }
        }

        return Math.min(flipCount, oneCount);
            
    }
    
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            System.out.print("Input: ");
            String input = sc.nextLine();
            int output = minFlipsMonoIncr(input);
            System.out.println("Output: " + output);
        }
    
}
