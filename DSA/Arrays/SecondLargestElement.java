package Arrays;

public class SecondLargestElement {
   
    public static int secondLarge(int arr[]){
        int l = 0, sl = -1;
        for(int i = 1; i<arr.length; i++){
            if(arr[i] > arr[l]){
                sl = l;
                l = i;
            }else if(arr[i] != arr[l]){
                if(arr[i] > arr[sl] || i == -1){
                    sl = i;//Happens only when their is no other second largest element(that, being all elements same) or the newly found element is larger than the previous second larger number but smaller than the largest element...
                }
            }
        }
        return sl;
        
        
    }
    public static void main(String[] args) {
        int arr[] = {15, 45, 20, 38};
        System.out.println(secondLarge(arr));
        
    }
}
