package Arrays;

public class RemoveDuplicates {

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

    public static int unduplicate(int arr[]){
        int res = 1;
        for(int i = 1; i<arr.length; i++){
            if(arr[i] != arr[res-1]){
                arr[res] = arr[i];
                res++;
            }
        }
        return res;
       

    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 2, 34, 34, 5, 6};
        System.out.println(unduplicate(arr));
        System.out.println();
        for(int i = 0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
        
    }
    
}
