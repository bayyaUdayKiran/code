
/**
 * A personal Library class for few well-known sorting algorithms.
 *
 * @author Uday Kiran
 */

package Lib;
import java.util.*;

public class Sort {
    /**
     * <pre>
     * {@code public static void bubble(int arr[])}
     * </pre>
     * Bubble sort algorithm, sorts the given array, by comparing adjacent elements and swapping them, according to their desired positions.
     * @param arr -> Un-sorted input array.
     */
    public static void bubbleSort(int arr[]){
        boolean SWAP_STAT = false;
        int n = arr.length;
        for(int i = 0; i<arr.length; i++){//This ensures, 'n-1' passes to happen, for every pass the largest element gets accumulated at the end of the array, and in the next pass the second largest element gets settled, vice-versa...
            for(int j = 0; j<n-1; j++){
                if(arr[j]>arr[j+1]){
                    Utility.swap(arr, j, j+1);
                    SWAP_STAT = true;
                }
            }
            if(!SWAP_STAT) break;

            n--;//This ensures that the comparison for swapping is to be done in search for the next largest element, but not the previously evaluated largest elements in every pass, as those are already placed in their desired areas...
        }
    }


    /**
     * <pre>
     * {@code public static void selectionSort(int arr[])}
     * </pre>
     * 
     * @param arr -> Un-sorted input array.
     */
    public static void selectionSort(int arr[]){
        for(int i = 0; i<arr.length; i++){
            int min_indx = i;
            // Linear search or finding the minimum element...
            for(int j = i+1; j<arr.length; j++){
                if(arr[j]<arr[min_indx]) min_indx = j;
            }  
            //Swapping the minimum element with currently iterating element.That is moving the minimum element to it's correct position
            Utility.swap(arr, i, min_indx);
        }
    }

    public static void insertionSort(int[] arr) {
        for(int i=1; i<arr.length; i++){
            int curr = arr[i];
            int j = i-1;
            while(j>=0 && arr[j]>curr/*Here, the `>` sign makes this algorithm a stable sorting algorithm, as no 2 same elements in the original un-sorted array will not change their positions(if, `>=` used there is a possibility of doing so. That is changing the original positions of same elements. Thus disturbing the algorithm's stabiliy)*/ ){
                //This is used to move larger elements to right side for making space to insert the `curr` element at it's right position...
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = curr;//This finally places the `curr`, element at it's desired position...
        }
    }



    public static void mergeSort(int arr[], int l, int r){
        if(l<r){
            int m = l + (r-l)/2;//Used to calculate mid index value. This special implementation of calculating mid rather than the simple calculation (l+m)/2 is because, if l and r are large positive integers, the sum l + r could potentially overflow the capacity of the integer data type, leading to unexpected results or errors.
            mergeSort(arr, l, m);//Recursively divides the left sub-array of the main input array untill each sub-array holds one and only element.
            mergeSort(arr, m+1, r);//Recursively divides the right sub-array of the main input array untill each sub-array holds one and only element.
            Utility.merge(arr, l, m, r);//Merges the divided sub-arrays at every step of division by making sure that the elements are sorted.
        }
    }

    public static void lQSort(int arr[], int l, int h){
        if(l<h){
            int p = Utility.lPartition(arr, l, h);
            lQSort(arr, l, p-1);
            lQSort(arr, p+1, h);
        }
    }

    public static void hQSort(int arr[], int l, int h){
        if(l<h){
            int p = Utility.hPartition(arr, l, h);
            hQSort(arr, l, p);
            hQSort(arr, p+1, h);
        }
    }

    public static void heapSort(int arr[]){
        int n = arr.length;
        //Build a max heap..
        Utility.build_heap(arr);

        for(int i = n-1; i>=1; i--){
            Utility.swap(arr, 0, i);

            //Heapify the reduced heap..
            Utility.min_heapify(arr, i, 0);
        }  
    }

     /**
     * <pre>
     * {@code public static void countingSort(int arr[])}
     * </pre>
     * Implements the counting sort algorithm for sorting an array of non-negative integers in ascending order.
     * <P>
     * This particular implementation is un-stable and is designed for sorting arrays of integers. It relies on the assumption that the elements in the input array are non-negative integers used as keys. This implementation doesn't work in sorting key-value pairs.
     * In working, it creates an auxiliary count array to store the frequency of each unique element in the input array and then constructs the sorted output array, considering the count array.
     * </p>
     * 
     * <p>
     * <STRONG> NOTE :- </STRONG>
     * <ul>
     *  <li> 
     *      This implementation is not stable, meaning it does not guarantee the preservation
     *      of the relative order of equal elements in the sorted output. It is suitable for sorting
     *      arrays of integers where stability is not a requirement. 
     * </li>
     * 
     * <li>
     *      This implementation is not suitable for sorting arrays with elements as key-value pairs, 
     *      because it assumes integer values as keys and lacks the necessary mechanisms for differentiating two key-value pairs with same key values and thus fails in sorting.
     * </li>
     * </ul>
     * </p>
     * 
     * @param arr non-negative integer array
     * @return returns {@code true}, if sorting is successful and {@code false}, if sorting is un-successful
     */
    public static boolean countingSort(int arr[]){
        if(arr == null) return false;
        int k = Utility.largest(arr) + 1;
        int count[] = new int[k];
        int indx = 0;

        for(int i = 0; i<arr.length; i++)
            count[arr[i]]++;
        
        for(int i = 0; i<k; i++){
                for(int j = 0; j<count[i]; j++){
                    arr[indx] = i; 
                    indx++;
                }
        }
        return true;
    }

    /**
     * <pre>
     * {@code public static void stableCountingSort(int arr[])}
     * </pre>
     * Implements the counting sort algorithm for sorting an array of non-negative integers in ascending order.
     * <P>
     * This algorithm ensures the stability property, preserving the relative order of equal elements
     * in the sorted output. The input array contains integer values used as keys.
     * </p>
     * 
     * <p>
     * <STRONG> Working:- </STRONG>
     * <ol>
     *     <li> 
     *          <STRONG> Counting phase: </STRONG>At first, it builds a auxiliary count array, which stores the frequency of each element in the input array.
     *     </li>
     *        
     *     <li> 
     *          <STRONG> Positioning phase: </STRONG> The count array is then modified to store the position of each element in the sorted array. This is achieved by updating each count value to be the sum of its current value and the value at the previous index(cumulative sums).
     *     </li>
     * 
     *     <li> 
     *          <STRONG> Building an auxiliary sorted array: </STRONG> Using the modified count array, the algorithm builds a new auxiliary sorted array by placing each element in its correct sorted position. In action, the algorithm iterates every element in the main input array(in right to left order, which is to ensure the stability of the sorting algorithm), checks the position of the particular element as per the 2nd phase modified count array(which, stores every element's position) and places those elements inside an auxiliary array named sorted.
     *     </li>
     * 
     *     <li> 
     *          <STRONG> Copying back: </STRONG> Directly copying the entire sorted auxiliary array to the original input array.
     *     </li>
     * </ol>
     * </p>
     
     * @param arr non-negative integer array
     * @return returns {@code true}, if sorting is successful and {@code false}, if sorting is un-successful
     */
    public static void stableCountingSort(int arr[]){
        int k = Utility.largest(arr) + 1;
        int count[] = new int[k], sorted[] = new int[arr.length];
        for(int i = 0; i<arr.length; i++)
            count[arr[i]]++;

        for(int i = 1; i<k; i++)
            count[i] = count[i-1] + count[i];
        
        for(int i = arr.length - 1; i >= 0; i--){
            sorted[count[arr[i]] - 1] = arr[i]; 
            count[arr[i]]--;
        }
        Utility.cpArray(sorted, arr);
    }


    /**
     * <pre>
     * {@code public static void radixSort(int arr[])}
     * </pre>
     * Sorts the given integer array using Radix Sort algorithm.
     * <p>
     * <STRONG>Basic Idea: </STRONG>
     * <ul>
     *      <li> In a positional numeral system, a number is represented as a string of digits, where each digit's position represents a power of the radix. For example, in the decimal system (radix 10), the number 735 is represented as {@code 7×10^2 + 3x10^1 + 5x10^0}. 
     *      <li>Radix sort takes advantage of this positional structure by sorting the elements digit by digit, starting from the least significant digit (LSD) to the most significant digit (MSD). </li></li>
     * 
     * </ul>
     * </p>
     * <p>
     * Radix Sort is a non-comparative sorting algorithm that works by distributing elements into buckets,
     * according to it's individual digits. It performs multiple passes over the input array, sorting the elements
     * based on their digits at different positions. During every pass all the array elements are sorted, based on their buckets(which are holding a particular  digit of array elements). In this way, in every pass a different digit(bucket) is considered and array elements are sorted. By this way when the final pass is completed, the array will be sorted.
     * </p>
     * <p>
     * In detail, this function calls the {@code radixCountSort} function for each digit position, starting from the least significant digit to the most significant digit. At every pass the array is sorted as per the particular exponent(digit). And there will be 'n' number of passes. Where 'n', is the number of digits the largest element of the array consists.
     * The working is just similar to that of the counting sort algorithm. But instead of considering each & entire element. This algorithm considers one digit after the other as discussed above. 
     * This special implementation can easily handle many problems that normal counting sort algorithm couldn't.
     * </p>
     * <p>
     * <STRONG>Pros:- </STRONG>
     *      <ol>
     *          <li> <STRONG>Handles Larger Range of Input Values: </STRONG>
     *          <ul>
     *              <li> Counting Sort is most effective when the range of input values (the difference between the maximum and minimum values) is not significantly larger than the number of elements in the input array. If the range is much larger, the Counting Sort approach becomes less practical due to the memory requirements. </li>
     *              <li> Whereas, radix Sort can handle a larger range effectively by sorting digits at different positions independently. Each pass of Radix Sort considers one digit at a time, allowing it to handle numbers with a larger range more efficiently.
     *          </ul>
     *          </li>
     * 
     *          <li> <STRONG>Stability: </STRONG>
     *          <ul>
     *              <li>Radix sort is stable (preserves the order of elements with equal keys). </li>
     *              <li> Counting sort can be stable or unstable, depending on the implementation. </li>
     *          </ul>
     *          </li>
     *      </ol>
     * </p>
     * <p>
     * <STRONG>Note:- </STRONG> When considered with input arrays with smaller range, {@code counting sort} algorithm outperforms radix sort, both in space & time complexity.
     * @param arr integer array
     * @return returns {@code true}, if sorting is successful and {@code false}, if sorting is un-successful
     */
    public static boolean radixSort(int arr[]){
        int max = Utility.largest(arr);

        for(int exp = 1; max/exp>0; exp*=10)
            if(!Utility.radixCountSort(arr, exp))
                return false;

        return true;
    }


      /**
     * <pre>
     * {@code public static void bucketSort(int arr[], int k)}
     * </pre>
     * Sorts the given integer array using Bucket Sort algorithm.
     * <p>
     * <STRONG>Basic Idea: </STRONG>
     * <ul>
     *      <li> The Bucket Sort algorithm divides the input array into a number of buckets,
     *           places each element into its corresponding bucket, and then individually sorts each bucket. 
     *           Finally, the sorted buckets are concatenated to produce the final sorted array. 
     *      </li>
     * </ul>
     * </p>
     * <p>
     * Bucket Sort is a non-comparative sorting algorithm that implements divide and conquer model to sort the given array.
     * In detail, the execution of the bucket sort algorithm happens this way,
     * </p>
     * 
     * <p>
     * <ol>
     * <li> <STRONG> Bucket Range Calculation: </STRONG>
     *      <ul>
     *          <li> Initially, the range of each bucket is calculated by considering the number of buckets available.
     *          <li> The range of each bucket is determined by the difference between the maximum and minimum values in the input array. This range is then divided by the number of buckets to calculate the size of each bucket. </li>
     *      </ul>
     * </li>
     * 
     * <li> <STRONG> Distribution of Elements: </STRONG>
     *      <ul>
     *          <li> Bucket sort operates on the assumption that the input elements are uniformly distributed across the range. This assumption is crucial for achieving good performance. </li>
     *          <li> In the distribution step, each element of the input array is placed into its corresponding bucket based on its value. The calculation of the bucket index is typically done using the formula (element - min) / bucketRange. The last bucket may need special handling to include the maximum value. </li>
     *      </ul>
     * </li>
     * 
     * <li> <STRONG> Individual Bucket Sorting: </STRONG>
     *      <ul>
     *          <li> After the elements are distributed into buckets, each bucket is individually sorted. 
     *               The sorting can be done using another sorting algorithm (e.g., insertion sort, quicksort, or mergesort) or a built-in sorting function. 
     *          </li>
     *      </ul>
     * </li>
     * 
     * <li> <STRONG>Concatenation of Buckets: </STRONG>
     *      <ul>
     *          <li> Once each bucket is sorted, the sorted buckets are concatenated to produce the final sorted array. The order of concatenation is based on the order of the buckets.</li>
     *      </ul>
     * </li>
     * </ol>
     * </p>
     * 
     * <p>
     * <STRONG>Pros:- </STRONG>
     * <ul>
     *      <li> The algorithm allows users to specify the number of buckets (k), providing some flexibility in adapting to different scenarios. Users can experiment with different values of k to find an optimal setting. </li>  
     *      <li> Bucket sort is well-suited for scenarios where the input data is uniformly distributed across a known range. In such cases, it can achieve good performance. </li>
     *      <li> In the best-case scenario, where the input elements are uniformly distributed and the individual bucket sorting is efficient, the time complexity can approach linear time. This is advantageous for certain types of input data. </li>
     * </ul>
     * </p>
     * 
     * <STRONG>Cons:- </STRONG>
     * <ul>
     *      <li> Bucket sort is sensitive to the distribution of input elements. If the data is not uniformly distributed, some buckets may be significantly larger than others, leading to suboptimal performance. </li>  
     *      <li> The performance of the algorithm is influenced by the choice of sorting algorithm for individual buckets. If a less efficient sorting algorithm is used, it can impact the overall efficiency of the algorithm. </li>
     *      <li> The provided implementation is not in-place, meaning it requires additional space proportional to the size of the input array. This can be a drawback in situations where memory usage is a concern. </li>
     *      <li> Depending on the distribution of input data, some buckets may remain empty, leading to additional space overhead without contributing to the sorting process. </li>
     * </ul>
     * </p>
     * <p>
     * <STRONG>Note:- </STRONG> Bucket sort is often stable, meaning that the relative order of equal elements is preserved during the sorting process. This stability depends on the stability of the sorting algorithm used for individual buckets.
     * And the number of buckets used in the algorithm is a critical parameter. If the number of buckets is too small, it may lead to clustering of elements in the same bucket, affecting the efficiency of the algorithm. If it's too large, the overhead of managing numerous empty buckets could reduce performance.
     * The time complexity of bucket sort is influenced by the distribution of elements and the sorting algorithm used for individual buckets. In the best-case scenario, where the elements are evenly distributed, and the individual bucket sorting is efficient, the time complexity can be close to linear. Mostly the time complexity of this algorithm is ideal, when the available buckets are more.
     * But, the space complexity of bucket sort is dominated by the space required for the buckets. The overall space complexity is determined by the number of buckets and the space required for sorting individual buckets.
     * @param arr integer array
     * @param k number of buckets
     * @return returns {@code true}, if sorting is successful and {@code false}, if sorting is un-successful
     */
    public static void bucketSort(int arr[], int k){
        //Finds the largest & smallest valued elements within the input array.
        int max = Utility.largest(arr);
        int min = Utility.smallest(arr);

        //Initializes an ArrayList capable of storing the buckets.
        ArrayList<Integer>[] buckets = new ArrayList[k];

        //Calculates the range of each bucket, that is the maximum number of elements any bucket can store.
        double bucketRange = (double) (max - min) / k;
        
        //Creating the buckets as ArrayLists.
        for(int i = 0; i<k; i++)
            buckets[i] = new ArrayList<>();

        
        //Allocating every element of the input array into their respective buckets by considering their value.
        int indx = 0;
        for(int num : arr){
            indx = (int) ((num-min)/bucketRange);
            indx = (indx == k) ? indx - 1 : indx;//Sometimes by calculation, the `index` may point to the bucket after the last element. Which is not possible. And if it happens the index gets decremented and points the last available bucket.
            buckets[indx].add(num);
        }

        //Sorting each bucket individually.
        for(ArrayList<Integer> bucket : buckets)
            Collections.sort(bucket);

        //Concatenating the sorted individual buckets to get the final sorted resultant array.
        int index = 0;
        for(ArrayList<Integer> bucket : buckets){
            for(int num : bucket)
                arr[index++] = num; 
        }
    }
}

