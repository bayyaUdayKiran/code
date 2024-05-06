import java.util.*;
public class MaxOfArray{
    public static void main(String[] args) {
        int arr[] = {23, 31, 1, 56, 8, 90, 64, 78, 11};
        System.out.println(max(arr));  
    }
    static int max(int[] arr){
        Arrays.sort(arr);
        return arr[arr.length-1];
    }

    
}