public class LastOccurrence{
    public static void main(String[] args) {
        int arr[] = {1, 2, 54, 54, 54, 6, 54, 7, 8, 54};
        System.out.println(search(arr, 54, 0, arr.length-1));
        
    }

    public static int search(int arr[], int x, int start, int end){
        if(start>end) return -1;
        int i = (start + end)/2;
        if(arr[i]>x) return search(arr, x, start, end-1);
        else if(arr[i]<x)return search(arr, x, start+1, end);
        else{
            if((i==arr.length-1)||(arr[i] != arr[i+1])){
                return i;
                
            }else{
                return search(arr, x, start+1, end);
            }
        }
        

    }
}