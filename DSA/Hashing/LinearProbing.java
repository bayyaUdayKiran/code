public class LinearProbing {
    public static void main(String[] args) {
        int bucket = 8;
        int table[] = new int[bucket];
        insert(table, 40, bucket);
        insert(table, 80, bucket);
        insert(table, 51, bucket);
        System.out.println(search(table, 80, bucket));
        System.out.println(search(table, 51, bucket));
        delete(table, 51, bucket);
        System.out.println(search(table, 51, bucket));
        System.out.println(search(table, 40, bucket));

        /*System.out.println();
        for(int i = 0; i<bucket; i++){
            System.out.println(table[i]);
        }*/

        
    }

    public static void insert(int table[], int n, int bucket){
        int i = n%bucket;
        if(table[i] == 0 || table[i] == -1) table[i] = n; 
        else{
            int j = i+1;
            while(j!=i){
                if(j==bucket-1) j = 0;//If pointer reaches the end of the array, make it to move circular by shifting it to the starting index..
                if((table[j]==0)||(table[j]==-1)){
                    table[j] = n; //Insert element only if the current position is empty or marked as deleted(-1), if not go for the next position..
                    break;
                } 
                j++;
            }
        }
    }

    public static void delete(int table[], int n, int bucket){
        int i = n%bucket;
        if(table[i] == n) table[i] = -1;
        else{
            int j = i+1;
            while(j!=i){
                if(j==bucket-1) j = 0;
                if(table[j]==n) {
                    table[j] = -1; 
                    break;
                }
                j++;
            }
        }
    }

    public static boolean search(int table[], int n, int bucket){
        boolean STAT = false;
        int i = n%bucket;
        if(table[i] == n) return true;
        else{
            int j = i+1;
            while(j!=i){
                if(table[j] == 0) break;
                if(j==bucket-1) j = 0;
                if(table[j]==n) {
                    STAT = true; 
                    break;
                }
                j++;
            }
            return STAT;

        }
    }

 


}
