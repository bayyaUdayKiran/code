import java.util.HashSet;

public class DistinctElements{
    public static void main(String[] args) {
        int arr[] = {1, 1, 23, 3, 23, 4, 56, 4};
        System.out.println(distinctCount(arr));
        
    }

    public static int distinctCount(int arr[]){
        HashSet<Integer> h = new HashSet<>();
        for(int i = 0; i<arr.length; i++){
            h.add(arr[i]);
        }
        return h.size();
    }
}