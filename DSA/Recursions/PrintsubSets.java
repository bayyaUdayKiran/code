public class PrintsubSets{
    public static void main(String[] args) {
        printSubs("abc", "", 0);
        System.out.println();
    }

    public static void printSubs(String s, String curr, int i){
        if(i == s.length()){
            System.out.print(" " + curr);
            return;
        } 
        
        printSubs(s, curr, i+1);
        printSubs(s, curr+s.charAt(i), i+1);


    }
    
}