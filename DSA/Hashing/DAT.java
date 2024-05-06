//Program describing the working of Direct Acess Table..
//Considering a situation where we have 1000 keys with values ranging from (0-999)...
//Our goal here's to perform, 'search', 'insert', 'delete' operations in O(1) time..
public class DAT{
    public static void main(String[] args) {
        int dat[] = new int[1000];

        insert(dat, 45);
        insert(dat, 879);
        System.out.println( search(dat, 879));
        System.out.println(search(dat, 456));
        delete(dat, 879);
        System.out.println(search(dat, 879)); 
    }

    public static void insert(int dat[], int n){
        dat[n] = 1;
    }

    public static void delete(int dat[], int n){
        dat[n] = 0;
    }

    public static boolean search(int dat[], int n){
        if(dat[n] == 1) return true;
        else return false;
    }





}