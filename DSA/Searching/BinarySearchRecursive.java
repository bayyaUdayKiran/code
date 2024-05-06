public class BinarySearchRecursive {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 6, 7, 21, 35, 57, 643};
        System.out.println(search(arr, 643, 0, arr.length-1));
        
    }

    public static int search(int arr[], int x, int start, int end){
        if(start>end) return -1;
        int i = (start + end)/2;

        if(arr[i]==x) return i;
        else if(arr[i]>x) return search(arr, x, start, end-1);
        else return search(arr, x, start+1, end);
        

    }
}
