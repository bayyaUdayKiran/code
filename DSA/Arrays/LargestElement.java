package Arrays;
public class LargestElement {
    public static int findLargest(int arr[], int n){
        int indx = 0;
        for(int i = 1; i<n; i++){
            if(arr[i] > arr[indx]){
                indx = i;
            }
        }
        return indx;
    }


    public static void main(String[] args) {
        int arr[] = {1, 2, 34, 8};
        System.out.println(findLargest(arr, 4));
        

    }
}
