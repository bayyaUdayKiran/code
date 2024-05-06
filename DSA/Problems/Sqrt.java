//This method returns floor of the value of square root of any given number..
public class Sqrt {
    public static void main(String[] args) {
        System.out.println(sqrt(23));
        
    }

    public static int sqrt(int n){
        int start = 0;
        int end = n;
        int res = -1;

        while(start<=end){
            int mid = (start+end)/2;
            if((mid*mid) == n) return mid;
            else if((mid*mid)>n) end = mid-1;
            else{
                start = mid + 1;
                res = mid;
            } 
        }
        return res;

        
    }
}
