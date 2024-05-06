import java.util.*;

public class DistinctElement2 {
    public static void main(String[] args) {
        Integer arr[] = {1, 1, 23, 3, 23, 4, 56, 4};
        HashSet<Integer> h = new HashSet<>(Arrays.asList(arr));
        System.out.println(h.size());
    }
}
