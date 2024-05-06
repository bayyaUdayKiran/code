package Arrays;

public class ReverseArray {
    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void reverse(int arr[]){
        int end = arr.length - 1, start = 0;
        while(start<end){
            swap(arr, start, end);
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        int arr[] = {12, 34, 56, 78};
        reverse(arr);
        for(int i = 0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
        
    }
    
}
