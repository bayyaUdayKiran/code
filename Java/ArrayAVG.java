public class ArrayAVG {
    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40};
        System.out.println(avg(arr));

        
    }

    static int sum(int arr[]){
        int sum = 0;
        for(int val:arr){
            sum+=val;
        }
        return sum;
    }

    static int avg(int arr[]){
        return (sum(arr)/arr.length);

    }
}
