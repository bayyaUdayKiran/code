public class IsSorted {

    public static boolean isSorted(int arr[]){
        int pivot = arr[0];
        int i;
        for(i = 1; i<arr.length; i++){
            if(arr[i]>pivot){
                pivot = arr[i];
                continue;
            }else{
                break;
            }
        }
        
        if(i==arr.length){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        int arr[] = {11};
        System.out.println(isSorted(arr));
        
    }
    
}
