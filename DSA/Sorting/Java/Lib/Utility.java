package Lib;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

/**
 * A personal Utility class with some useful functionalities that can be used with sorting algorithms.
 *
 * @author Uday Kiran
 */
public class Utility {
    static long alpha, omega;

    /**
     * <pre>
     * {@code
     * public static void startTick()}
     * </pre>
     * Logs the current timestamp just before the program starts it's execution.
     */
    public static void startTick(){
        alpha = System.nanoTime();
    }

    /**
     * <pre>
     * {@code
     * public static void stopTick()}
     * </pre>
     * Logs the current timestamp just after the program completes it's execution.
     */
    public static void stopTick(){
        omega = System.nanoTime();  
    }

    /**
     * <pre>
     * {@code
     * public static void elps()}
     * </pre>
     * Used alongwith {@code startTick} & {@code stopTick} methods for calculating the elapsed time for a program's execution in seconds. And then prints the time elapsed onto the console via the {@code std:output} stream.
     */
    public static void elps(){
        long elpsTime =  omega - alpha;
        double elpsTimeSec = (double) elpsTime / 1_000_000_000.0;
        DecimalFormat df = new DecimalFormat("#.###");
        String theElpsTime = df.format(elpsTimeSec);
        System.out.println("Completed in, " + theElpsTime + "sec");
    }

     /**
     * <pre>
     * {@code
     * public static int largest(int arr[])
     * }
     * </pre>
     * Finds out the largest number element in the given input array.
     * <p>
     * This algorithm iterates the entire array and finds out the largest element by continuously updating the largest element pointer(if the currently iterating element is larger than previously marked element)
     * @param arr - input array, whose elements are meant to be swapped.
     * @return returns largest element in the array if execution is successful or {@code -1}, if array is empty or null.
     */
    public static int largest(int arr[]){
        if(arr==null || Utility.isEmpty(arr)){
            System.out.println("*\n*\n****ERROR!****************************************\n`largest`: can't operate on null or empty arrays!\n**************************************************\n*\n*");
            return -1;
        }
        int large = arr[0];
        for(int i = 1; i<arr.length; i++){
            if(arr[i] > large)
                large = arr[i];
        }
        return large;
    }

    public static int smallest(int arr[]){
        if(arr==null || Utility.isEmpty(arr)){
            System.out.println("*\n*\n****ERROR!****************************************\n`smallest`: can't operate on null or empty arrays!\n**************************************************\n*\n*");
            return -1;
        }

        int small = arr[0];
        for(int i = 1; i<arr.length; i++){
            if(arr[i]<small)
                small = arr[i];
        }
        return small;

    }

    /**
     * <pre>
     * {@code
     *  public static int isEmpty(int arr[])}
     * </pre>
     * Finds out whether the given array is empty or not.
     * <p>
     * This algorithm uses conditional statments to check whether the array is null or empty, by using an another utility function namely {@code isEmpty()}, which internally does the actual check.
     * @param arr - input array.
     * @return returns program status, if array is null or not empty {@code false}, if not {@code true} is returned.
     */
    public static boolean isEmpty(int arr[]){
        if(arr==null){
            System.out.println("*\n*\n***ERROR!**************************************\n`isEmpty`-> can't operate on null array!\n***********************************************\n*\n*");
            return false;
        }
        if(arr.length == 0)
            return true;
        else
            return false;
    }

     /**
     * <pre>
     * {@code
     *   public static boolean cpArray(int src[], int dest[])}
     * </pre>
     * Copies the elements from the source array {@code src[]} to the destination array {@code dest[]}.
     * <p>
     * <STRONG> NOTE:- </STRONG>
     * This method checks for valid input conditions before attempting the copy. 
     * The source and destination arrays must not be null, and they must have the same length for a successful copy.
     * <p>
     * <STRONG>INVALID PARAMETERS:- </STRONG> 
     * <ul>
     *      <li> Input arrays shouldn't be null. </li>
     *      <li> {@code src} array shouldn't be empty. </li>
     *      <li> The provided swappable index positions should be in bound with the input array. </li>
     * </ul>
     * </p>
     * If the input arrays are valid, each element of the source array is iteratively copied to the corresponding position in the destination array.
     * </p>
     * @param src - The source array, from which elements will be copied.
     * @param dest - The destination array, into which elements from {@code dest[]} will be copied.
     * @return program status, after successful execution returns, {@code true}, if not {@code false} and if a null array is passed as param, returns {@code false}
     */
    public static boolean cpArray(int src[], int dest[]){
        if(src == null || dest == null || src.length != dest.length){
            System.out.println("*\n*\n***ERROR!**************************************\n`cpArray`-> can't operate on invalid params!\n***********************************************\n*\n*");
            return false;

        }
            
        for(int i = 0; i < src.length; i++)
            dest[i] = src[i];
        
        return true;
    }

    /**
     * <pre>
     * {@code
     * public static boolean swap()
     * }
     * </pre>
     * Swaps two elements of a non-empty array in position.
     * <p>
     * In action, this algorithm uses a temp variable to store one swappable element's value then the element's value is modified into the other swappable element. And the previously stored temp value is now stored back into the latter swappable position.
     * </p>
     * <p>
     * <STRONG>NOTE:- </STRONG> 
     * <ul>
     *      <li> Input array shouldn't be null. </li>
     *      <li> Input array shouldn't be empty. </li>
     *      <li> The provided swappable index positions should be in bound with the input array. </li>
     * </ul>
     * </p>
     * @param arr - input array.
     * @param a - index of one of the swappable element.
     * @param b - index of another swappable element.
     * @return returns status code, when successfully swapped elements, {@code true} if, {@code false} : execution failure, because of any reasons specified in the  above mentioned, `NOTE`. 
     */
    public static boolean swap(int arr[], int a, int b){
        if(arr != null && !Utility.isEmpty(arr) && a>=0 && a<arr.length && b>=0 && b<arr.length){
            int temp = arr[b];
            arr[b] = arr[a];
            arr[a] = temp;
            return true;
        }else{
            System.out.println("*\n*\n*****ERROR**********************************************************************************************\n`swap`-> Can't operate on null or empty arrays or array with invalid index positions, \n********************************************************************************************************\n*\n*");
            return false;
        }
                
        
        
    }

    /**
     * <pre>
     * {@code public static boolean populateArray(int arr[])}
     * </pre>
     * Populates an integer array via the {@code std:input} stream. 
     * <p>
     * This algorithm accepts input from the user, and then stores each element provided by the user as input into the array, iteratively.
     * </p>
     * 
     * <p>
     * <STRONG>NOTE:- </STRONG> 
     * <ul>
     *      <li> Input array shouldn't be null. </li>
     *      <li> Input array shouldn't be empty. </li>
     *      <li> The input characters should be of type {@code int}. </li>
     * </ul>
     * </p>
     * @param arr input array
     * @return returns program's status, if array gets successfully populated, {@code true} is returned. And if not, {@code false} is returned.
     */
    public static boolean populateArray(int arr[]){
        if(arr!=null && !Utility.isEmpty(arr)){
            try{
                Scanner sc = new Scanner(System.in);
                for(int i = 0; i<arr.length; i++){
                    System.out.print("arr[" + i + "]: ");
                    arr[i] = sc.nextInt();
                }
                sc.close();
            }catch(InputMismatchException e){
                System.out.println("*\n*\n*********ERROR*******************************************************\n`populateArray` -> Invalid input. Can't insert it into the array\n*********************************************************************\n*\n*");
                return false;

            }      
        }else{
            System.out.println("*\n*\n*********ERROR*******************************************************\n`populateArray` -> Can't operate on empty or null input arrays\n*********************************************************************\n*\n*");
            return false;

        } 

        return true;
    }

    /**
     * <pre>
     * {@code  public static int[][] split(int arr[], int mid)}
     * </pre>
     * Splits a given input array into two sub-arrays based on the given {@code mid} position. That is, elements before mid position including mid becomes one half and elements after the mid to the ending position are divided to the second half.
     * @param arr input array
     * @param mid mid index position
     * @return 2-D Array holding the two sub-arrays. One at the 0th index row & the other 1st index row
     * @throws NullPointerException if the input array is null.
     */
    public static int[][] split(int arr[], int mid){
        int [][]res = new int[2][];
        
        
        int lSize = mid+1; 
        int rSize = (arr.length) - mid; 
        int l[] = new int[lSize];
        int r[] = new int[rSize];




        for(int i = 0; i<arr.length; i++){
            if(i<=mid) l[i] = arr[i];
            else r[i-lSize] = arr[i];
        }

        
        res[0] = l;
        res[1] = r;

        return res;
    }

     /**
     * <pre>
     * {@code public static boolean isSorted(int arr[], boolean rev)}
     * </pre>
     * Checks whether the given input array is sorted or not.
     * @param arr input array
     * @param rev is reversely sorted?(i.e, sorted in descending order), acceptable args: {@code true} or {@code false}
     * @return returns {@code true} if array is sorted and {@code false} if array is un-sorted
     */
    public static boolean isSorted(int arr[], boolean rev){
        if(arr == null || Utility.isEmpty(arr)){
            System.out.println("*\n*\n*********ERROR*******************************************************\n`isSorted` -> Can't operate on empty or null input arrays\n*********************************************************************\n*\n*");
            return false;
        }
        int temp;
        temp = arr[0];
        for(int i = 1; i<arr.length; i++){
            if((arr[i]<temp)&&(!rev))
                return false;
        }
        return true;
    }


     /**
     * <pre>
     * {@code public static void merge(int l[], int r[])}
     * </pre>
     * Merges two sorted arrays into a single sorted array. If any of the given input array isn't sorted an array populated with {@code -1} will be returned.
     * @param l input sub-array 1
     * @param r input sub-array 2
     * @return after successful merging, returns merged & sorted array or 
     * returns an array populated with {@code -1}, as elements if operation is un-successful.
     * @throws NullPointerException if the input arrays `l` or `r` are null.
     */
    public static int[] merge(int l[], int r[]){
        int res[] = new int[l.length + r.length];
        if(Utility.isSorted(l, false)&&(Utility.isSorted(r, false))){
            int i = 0, j = 0, counter = 0;
            while((i<l.length) && (j<r.length)){
                if(l[i]<r[j])
                    res[counter++] = l[i++];
                    
                else
                    res[counter++] = r[j++];
                
                
            }

            while(i<l.length){
                res[counter++] = l[i++];
            }

            while(j<r.length){
                res[counter++] = r[j++];
            }

            return res;

        }else{
            for(int i = 0; i<l.length + r.length; i++){
                res[i] = -1;
            }
            return res;

        }
        
    }

    public static int largestDigit(int arr[]){
        int max = largest(arr), large = 0;
        for(int exp = 1; max/exp>0; exp*=10){
            for(int j = 0; j<arr.length; j++){
                if((arr[j]/exp)%10 > large)
                    large = (arr[j]/exp) % 10;
            }

        }
        return large;
    }

    /**
     * <pre>
     * {@code public static void merge(int arr[], int li, int m, int ri)}
     * </pre>
     * Merges two sorted arrays into a single sorted array. Besides standalone operations, this algorithm is mostly used with the merge sort recursive algorithm, for achieving the conquering functionality, as the merge sort algorithm is based on divide and conquer principle.
     * It basically assumes 2 sub-arrays within the given single input array, by knowing the starting, ending & mid positions of the given input array.
     * These assumptions are:  The index position {@code li} is the staring index position and {@code m} is the ending index of the left most sub-array. And {@code (m+1)} is the starting index and {@code ri} is the ending index of the right most sub-array.
     * @param arr input array
     * @param li left most element's index
     * @param ri right most element's index
     * @param m mid element's index position
     * @return pivot element index
     */
    public static void merge(int arr[], int li, int m, int ri){
        int temp[] = new int[ri - li + 1];//a temporary array, with a size that could accomodate all elements of two arrays..

        int i = li, j = m+1, k = 0;
        while(i <= m && j <= ri){
            if(arr[i]<=arr[j]){
                temp[k++] = arr[i++];//If element in left array is smaller than of that, in right array, append that particular element into the temp array and increment the left array counter pointer(i). So that next element of left array could undergo comparision in the next coming iteration..
            }else{
                temp[k++] = arr[j++];//If element in right array is smaller than of that, in left array, append that particular element into the temp array and increment the right array counter pointer(j). So that next element of right array could undergo comparision in the next coming iteration..
            }     
        }

        //Directly appends the elements of left array into the temp array(if any elements are left behind in it without getting copied into the temp array)..
        while (i <= m) 
            temp[k++] = arr[i++];
        
    
        //Directly appends the elements of right array into the temp array(if any elements are left behind in it without getting copied into the temp array)..
        while (j <= ri) 
            temp[k++] = arr[j++];
        

        //Copies the array elements of temp into the actual input array(arr)..
        for(int p = li, q = 0; q<temp.length; p++, q++)
            arr[p] = temp[q];
    }

    /**
     * <pre>
     * {@code public static void partition(int arr[], int l, int h, int p)}
     * </pre>
     * In-effecient but stable partitioning algotithm, which partitions a given input array based on the given pivot element. Such that, all the elements lesser than the pivot gets stacked on the left side and all the larger elements(compared to pivot element) are arranged at the right side, centering the pivot element in the given input array.
     * @param arr un-partitioned input array
     * @param l first element's index
     * @param h last element's index
     * @param p pivot element's index
     */
    public static void partition(int arr[], int l, int h, int p){
        int temp[] = new int[h-l+1];
        int k=0;
        for(int i = l; i<=h; i++){
            if(arr[i]<arr[p]){
                temp[k] = arr[i];
                k++;
            }  
        }
 
        temp[k++] = arr[p];

        for(int i = l; i<=h; i++){
            if(arr[i]>arr[p]){
                temp[k] = arr[i];
                k++;
            }
        }

        for(int i = l; i<=h; i++){
            arr[i] = temp[i-l];
        }
    }

     /**
     * <pre>
     * {@code public static void lPartition(int arr[], int l, int h)}
     * </pre>
     * Partitions the array based on the lomuto partitioning scheme. The Lomuto partition scheme is named after the computer scientist Nico Lomuto, who introduced this partitioning algorithm. This partitioning scheme is commonly used in the quicksort algorithm for dividing an array into two parts - one with elements less than a chosen pivot and another with elements greater than the pivot. This algorithm isn't stable
     * 
     * @param arr un-partitioned input array
     * @param l first element's index
     * @param h last element's index
     * @param p pivot element's index
     * @return pivot element's index
     */
    public static int lPartition(int arr[], int l, int h){
        qOptima(arr, l, h, true);
        int pivot = arr[h], pi = l;
        for(int i = l; i<=h; i++){
            if(arr[i]<pivot){
                swap(arr, pi, i);
                pi++;
            }  
        }
        swap(arr, h, pi);

        return pi;
    }


     /**
     * <pre>
     * {@code public static void hPartition(int arr[], int l, int h)}
     * </pre>
     * Partitions the array based on the Hoare partitioning scheme, which is an unstable algorithm introduced by Tony Hoare, the British computer scientist who also developed the Quicksort algorithm. The position of the pivot element is un-predictable(i.e, the pivot might not be centered in between smaller and larger elements)
     * 
     * @param arr un-partitioned input array
     * @param l first element's index
     * @param h last element's index
     * @param p pivot element's index
     * @return returns an index position which is used to divide the array into two segments: elements to the left of the index are smaller than or equal to the pivot, and elements to the right are greater than or equal to the pivot. And in some implementations(cases) it might also be the index position of the pivot in the partitioned array.
     */
    public static int hPartition(int arr[], int l, int h){
        qOptima(arr, l, h, false);
        int pivot = arr[l], i = l-1, j = h+1;
        while(true){
            do{
                i++;
            }while(arr[i]<pivot);

            do{
                j--;
            }while(arr[j]>pivot);

            if(i>=j)
                return j;

            swap(arr, i, j);

        }
    }


    /**
     * <pre>
     * {@code public static void qOptima(int arr[], int l, int h, boolean lomuto)}
     * </pre>
     * <p>
     * Optimizes the quick sort algorithm, by swapping the pivot element with a random element within the same array.
     * This function considers two partitioning strategies to choose the pivot element:
     * </p>
     * 
     * <p>
     * 1. <STRONG>Lomuto's Partitioning:</STRONG> 
     *    If `lomuto` is true, the last element (`h`) is chosen as the pivot (`pi`). 
     *    This is typically used for Lomuto's partitioning scheme in quicksort, where
     *    the pivot is considered as the last element of the given array.
     * </p>
     * <p>
     * 2. <STRONG>Hoare Partitioning:</STRONG>
     *    If `lomuto` is false, the last element (`l`) is chosen as the pivot (`pi`). 
     *    This is typically used for Hoare's partitioning scheme in quicksort, where
     *    the pivot is considered as the first element of the given array.
     * </p>
     * 
     * <p>
     * After choosing the pivot as per the condition, a random element within the specified range (`l` to `h`)
     * is chosen and swapped with the before choosen pivot (`pi`). This can be beneficial for avoiding worst-case
     * scenarios, like array already being sorted, etc.., in quicksort, where choosing the first or last element as the pivot
     * can lead to imbalanced partitions and significantly slower performance.
     * </p>
     * 
     * @param arr The array containing the elements to be sorted.
     * @param l The lower bound of the sub-array to be partitioned (inclusive).
     * @param h The upper bound of the sub-array to be partitioned (inclusive).
     * @param lomuto Whether to use Lomuto's partitioning scheme (true) or random pivot selection (false).
     * @throws IndexOutOfBoundsException if  `l` and `h` are out of bound to the array.
     */
    public static void qOptima(int arr[], int l, int h, boolean lomuto){
        int pi = l;//pivot is first element, if the quick sort algorithm is using hoare partitioning scheme..
        if(lomuto)
            pi = h;//pivot is last element, if the quick sort algorithm is using lomuto partitioning scheme..

        int rp = new Random().nextInt(h - l + 1) + l;//selects a random index within the array

        swap(arr, rp, pi);//swaps the pivot element with the randomly selected array's element
    }

    public static void max_heapify(int arr[], int n, int i){
        int max = i;
        int li = (2*i) + 1, ri = (2*i) + 2;

        if(li < n && arr[li] > arr[max])
            max = li;

        if(ri < n && arr[ri] > arr[max])
            max = ri;

        if(max != i){
            Utility.swap(arr, i, max);
            max_heapify(arr, n, max);
        } 
    }

    public static void min_heapify(int arr[], int n, int i){
        int min = i;
        int li = (2*i) + 1, ri = (2*i) + 2;

        if(li < n && arr[li] < arr[min])
            min = li;

        if(ri < n && arr[ri] < arr[min])
            min = ri;

        if(min != i){
            Utility.swap(arr, i, min);
            min_heapify(arr, n, min);
        } 
    }

    public static void build_heap(int arr[]){
        int n = arr.length;
        for(int i = (n/2) - 1; i>=0; i--){
            min_heapify(arr, arr.length, i);
        }
    }

    /**
     * <pre>
     * {@code public static int duplicateCount(int arr[])}
     * </pre>
     * Counts the number of duplicate elements in the given input array.
     * <p>This method iterates through the array, comparing each element with the remaining elements. 
     * If a duplicate is found, it increments a counter and deletes the duplicate elements, so that it need not to consider it in the further iterations.
     * </p>
     * <p>
     * <STRONG> Note: This algorithm is naive in efficiency, as this requires another array(which is a copy of the original input array) in which the actual manipulations & comparisions are done. And the deletions are nothing but marking the element as -1.
     * @param arr input array
     * @throws NullPointerException if the input array is null.
     */
    public static int duplicateCount(int arr[]){
        int cparr[] = arr;
        int count = 0;//Counter, which counts number of duplicate elements inside the array
        for(int i = 0; i<arr.length; i++){
            for(int j = 0; j<arr.length; j++){
                if(cparr[i] == cparr[j] && cparr[j] != -1){
                    //if a duplicate element is found, increment the duplicate counter & delete the duplicate array, by marking the element as -1
                    count++;
                    cparr[j] = -1;
                }
            }
        }
        return count;
    }

    public static boolean radixCountSort(int arr[], int exp){
        int n = largestDigit(arr);//gets the largest digit within the entire input array, to initialize the `count` array using it(as it's size).

        if(n == -1)
        //As the function `largest`, is completely able to handle null & empty arrays. And if it returns '-1', then the our main function(radixCountSort) fails in execution.
            return false;
        
        int count[] = new int[n+1], sorted[] = new int[arr.length];

        //Storing the count of each element's digit, which is specified by the exponent called by the parent algorithm..
        for(int i = 0; i<arr.length; i++)
            count[(arr[i]/exp)%10]++;
        
        //Modifying `count` array to a cumulative sum array, which stores every element's position.
        for(int i = 1; i<n+1; i++)
            count[i] = count[i] + count[i-1];

        //Storing the actual element's of the input array into the `sorted` array as per the positions specified by the modified `count` array(cumulative sums array).    
        for(int i = arr.length - 1; i>=0;  i--){
            sorted[count[(arr[i]/exp)%10]-1] = arr[i];
            count[(arr[i]/exp)%10]--;
        }
        cpArray(sorted, arr);
        return true;
    }

    public static int minDiff(int arr[]){
        int diff = Integer.MAX_VALUE;
        if(arr.length == 1)
            return diff;

        Sort.lQSort(arr, 0, arr.length-1);
        for(int i = arr.length-1; i>0; i-=2){
            diff = Math.min(arr[i] - arr[i-1], diff);
        }
        return diff;
    }
}

