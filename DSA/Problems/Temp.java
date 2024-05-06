import java.util.*;
public class Temp {
    public static int sumArray(int[] a, int n){
        int res = 0;
        for(int i = 0; i<n; i++){
            res+=a[i];
        }
        return res;
    }
    
    public int[] kWeakestRows(int[][] mat, int k) {

        ArrayList<Integer> results = new ArrayList<>();
        int[] f = new int[k];
        //ArrayList<Integer> f = new ArrayList<>();
        for(int i = 0; i<mat.length; i++){
            results.add(sumArray(mat[i], mat.length));  
        }

        ArrayList<Integer> sorted = new ArrayList<>(results);
        Collections.sort(sorted);

        for (int i = 0; i < k; i++) {
           int temp =  sorted.get(i);
           //f.add(results.indexOf(temp));
           f[i] = results.indexOf(temp);
        }

        return f;

    }
    

    
}
