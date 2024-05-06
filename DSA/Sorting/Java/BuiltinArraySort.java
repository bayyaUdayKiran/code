import java.util.Arrays;

public class BuiltinArraySort {
    public static void main(String[] args) {
        int[] arr = {1, 6, 2, 45, 21, 5, 0, 89, 69};
        Arrays.sort(arr);
        System.out.print('[');
        for(int i = 0; i<arr.length; i++){
            if(i == (arr.length-1))
                System.out.print(arr[i]);
            else
                System.out.print(arr[i] + ", ");
            
        }
        System.out.print(']' + "\n");

        
    }

}
