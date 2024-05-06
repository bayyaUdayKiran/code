public class ArraySum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(sum(arr));

        
    }

    static int sum(int arr[]){
        int sum = 0;
        for(int val:arr){
            sum+=val;
        }
        return sum;
    }
}
