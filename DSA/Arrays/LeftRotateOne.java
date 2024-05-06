package Arrays;

public class LeftRotateOne {
    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void leftRotate(int arr[]){
        int start = 0, end = arr.length - 1;
        while(start<end){
            swap(arr, start, end);
            end--;
        }

    }
    public static void main(String[] args) {
        int arr[] = {34, 53, 65, 7, 90};
        leftRotate(arr);
        for(int i = 0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
        
    }
}
