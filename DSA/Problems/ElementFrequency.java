import java.util.HashMap;
import java.util.Map;

public class ElementFrequency {
    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 34, 5, 6, 7, 7, 34};
        freq(arr);
        
    }

    public static void freq(int arr[]){
        HashMap<Integer, Integer> h = new HashMap<>();
        for(int x : arr){
            h.put(x, h.getOrDefault(x, 0)+1); //The getOrDefault method fetches the value of any given particular pair if it's already exists in the Hash Map. If not it simply returns the provided default value, we specifically increment it to initialize the count of the particular element...
        }

        for(Map.Entry<Integer, Integer> e : h.entrySet()){
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }
}
