import java.util.Arrays;

public class ArrayDistinct {
    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 2, 3, 2, 33, 3, 3, 4, 5, 4};
        System.out.println(distinct(arr));
    }

    static int distinct(int arr[]){
        Arrays.sort(arr);
        int count = 1, temp = arr[0];
        for(int i = 1; i<arr.length; i++){
            if(arr[i] != temp){
                count++;
                temp = arr[i];
            } 
        }
        
        return count;
    }
}
