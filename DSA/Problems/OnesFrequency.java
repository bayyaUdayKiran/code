public class OnesFrequency{
    public static void main(String[] args) {
        int a[] =  {0, 0, 0, 0, 1, 1, 1};
        System.out.println(freq(a, 0, a.length-1));
        
    }

    public static int freq(int arr[], int start, int end){
        if(start>end) return 0;

        int mid = (start+end)/2;

        if((mid==0) || (arr[mid] != arr[mid-1])/*arr[mid] = 1; arr[mid-1] = 0 */){
            return arr.length-mid;
        }

        if(arr[mid] == 0){
            return freq(arr, start+1, end);//In na attempt to move forward and check for the first occurrence of 1..
        }else{
            return freq(arr, start, end-1);//In an attempt to read the array backwards to check where actually 1's started appearing..
        }
        
    
       
        
    }
}