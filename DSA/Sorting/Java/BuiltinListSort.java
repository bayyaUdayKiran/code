import java.util.ArrayList;
import java.util.Collections;

public class BuiltinListSort {
    public static void main(String[] args) {
        ArrayList<Integer> i = new ArrayList<Integer>();
        i.add(12);
        i.add(1);
        i.add(2);
        i.add(212);
        i.add(35);
        i.add(0);
        Collections.sort(i);
        System.out.println(i);
    }
    
}
