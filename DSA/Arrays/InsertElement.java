package Arrays;
import java.util.*;
public class InsertElement {
    public static int insert(int [] arr, int indx, int x, int n, int cap){
        if(n == cap){
            return n;
        }
        for(int i = n-1; i>=indx; i--){
            arr[i+1] = arr[i];
        }
        arr[indx] = x;
        return n+1;
    }
        


    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 0};
      
        for(int i = 0; i<arr.length; i++){
            System.out.println(arr[i]);
        }

        System.out.println();
        System.out.println(insert(arr, 1, 25, 3, 4)); 
        for(int i = 0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
        
    }


    
}
