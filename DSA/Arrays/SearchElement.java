package Arrays;

public class SearchElement {
    public static int search(int arr[], int x, int n){
        int i;
        for(i = 0; i<n; i++){
            if(arr[i] == x){
                break;
            }
        }
        if(i==n){
            return -1;
        }else{
            return i;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(search(arr, 3, 4));
        
    }
    
}
