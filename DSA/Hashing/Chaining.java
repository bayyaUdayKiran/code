import java.util.*;

class HashTable{
    int BUCKET;
    ArrayList<LinkedList<Integer>> table;//Declaration of Hash Table..
    HashTable(int b){
        BUCKET = b;
        table  = new ArrayList<LinkedList<Integer>>();
        for(int i = 0; i<b; i++){
            table.add(new LinkedList<Integer>());//Allocating memory for Hash Table by populating it with Linked Lists..
        }

    }

    int hash(int k){
        return (k%BUCKET);
    } 
    

    void insert(int k){
        int hashValue = hash(k);
        table.get(hashValue).add(k);
    }

    void delete(int k){
        int hashValue = hash(k);
        table.get(hashValue).remove((Integer) k);
    }

    boolean search(int k){
        int hashValue = hash(k);
        return table.get(hashValue).contains(k);
    }
}

public class Chaining{
    public static void main(String[] args) {
        HashTable h = new HashTable(5);
        h.insert(35);
        h.insert(45);
        h.insert(71);
        System.out.println(h.search(45));
        h.delete(45);
        System.out.println(h.search(45));
        
    }
}