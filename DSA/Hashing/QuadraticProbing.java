public class QuadraticProbing{
    public static void main(String[] args) {
        Hasher h = new Hasher(5);
        h.insert(40);
        h.insert(11);
        h.insert(12);
        h.insert(13);
        h.insert(14);
        h.insert(25);
        

        h.printTable();
        System.out.println();
        System.out.println(h.search(25));

        
    }

   
}

class Hasher{
    int CAPACITY;
    static int size = 0;
    static int table[];

    Hasher(int c){
        CAPACITY = c;
        table = new int[CAPACITY];
    }
    
    int insert(int x){
        int k = 1;
        int i = x%CAPACITY;

        if(size == CAPACITY) {
            System.out.println("Table is full..!");
            return -1;
        }

        if(table[i] == 0) {
            table[i] = x;
            size++;
            return 0;
        }else{
            int j = i+(k*k);
            while(j!=i){
                if(j==(table.length-1)){
                    j=0; //If the pointer reaches the end of the array, point it towards the starting position of the array..
                    i=0;
                } 

                if(table[j] == 0){
                    table[j] = x;
                    size++;
                    return 0;
                }
                k++;
                j=j+(k*k);
            } 
             

        }
        return -1;
        
        
    }

    int search(int x){
        int k = 1;
        int i = x%CAPACITY;

        if(table[i] == x) return i;
        else{
            int j = i + (k*k);
            while(j!=i){
                if(j==(table.length-1) || j==(table.length)){
                    j=0; //If the pointer reaches the end of the array, point it towards the starting position of the array..
                    i=0;
                    k = 1;
                } 

                if(table[j] == x) return j;
                k++;
                j = j+(k*k);
            }
        }
        return -1;
    }

    void printTable(){
        for(int i = 0; i<CAPACITY; i++){
            System.out.println(table[i]);
        }

    }

    int size(){
        return size;
    }

}

