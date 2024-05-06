package Arrays;

public class DeleteElement {
    public static int delete(int[] arr, int x, int n){
        boolean FOUND = true;
        boolean status = false;
        for(int i = 0; i<n; i++){
            if(arr[i] == x){
                status = FOUND;
                for(int j = i; j<n-1; j++){
                    arr[j] = arr[j+1];
                }
            } 
        }
        if(!status){
            return n;
        }
        arr[n-1] = 0;
        return n-1;

    }
    public static void main(String[] args) {
        
        int arr[] = {3, 8, 12, 5, 6};
        for(int i = 0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
        System.out.println();
        System.out.println(delete(arr, 15, 5));
        System.out.println();

        for(int i = 0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    
}
