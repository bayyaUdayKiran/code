public class Ransom{
    static int FOUND = 1;
    static int LOST = 0;

    public static void main(String[] args) {
        boolean res = ransomGen("aa", "aab");
        System.out.println(res);
        
    }

    public static boolean ransomGen(String ransom, String mag){
        int status = LOST;
        int k = 0;
        for(int i = 0; i<ransom.length(); i++){
            i = k;
            for(int j = 0; j<mag.length(); j++){
                if(mag.charAt(j) == ransom.charAt(i)){
                    status = FOUND;
                    i++;
                    k = i;
                }else{
                    status = LOST;
                }
            }
            if(status==LOST){
                return false;
            }
        }
        if(status==FOUND){
            return true;
        }else{
            return false;
        }
    }

    
}