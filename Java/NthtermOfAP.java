public class NthtermOfAP{
    public static void main(String[] args) {
        System.out.println(findN(2, 1, 5));
    }

    static int findN(int first, int cd, int n){
        int res = first, j = 0;
        for(int i = first; j<n; i+=cd){
            res = i;
            j++;
        }

        return res;
    }
}