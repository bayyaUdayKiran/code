package Arrays;
import java.util.*;

public class ZeroesToEnd {
    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    static void dislocateZeroes(int arr[]){
        int res = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i]!=0){
                swap(arr, res, i);
                res++;
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {0, 12, 3, 0, 4, 0, 9, 0, 0, 76, 45};
        dislocateZeroes(arr);
        for(int i = 0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
        

    }
}
