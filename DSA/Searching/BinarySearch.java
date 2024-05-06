//Note, this algorithm returns any of the occurrence of the searching number randomly if it has any duplicates...
public class BinarySearch{
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 6, 7, 21, 35, 57, 643};
        System.out.println(search(arr, 57));
        
    }

    public static int search(int arr[], int x){
        int index = -1;
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int i = (start+end)/2;
            if(arr[i] == x){
                index = i;
                break;
            }
            if(arr[i]>x) end--;
            if(arr[i]<x) start++;
        }
        return index;
        
        
    }
}