//Note, this algorithm returns the first occurrence of the searching number in the array if it has any duplicates..
public class LinearSearch {
    public static void main(String[] args) {
        int arr[] = {1, 2, 21, 35, 57, 3, 6, 7, 643};
        System.out.println(search(arr, 643));
        
    }

    public static int search(int arr[], int x){
        int index = -1;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == x){
                index = i;
                break;
            }
        }
        return index;
    }
}
