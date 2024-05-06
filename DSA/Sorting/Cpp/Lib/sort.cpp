# include "headers/utility.h"
# include <cstdlib>
# include <iostream>

using namespace std;

void merge_sort(int arr[], int li, int ri, int n){
    if(li<ri){
        int mid = li + (ri-li)/2;
        merge_sort(arr, li, mid, n);
        merge_sort(arr, mid+1, ri, n);
        merge(arr, li, ri, mid, n);
    }
}

void lQSort(int arr[], int li, int hi){
    if(li < hi){
        int p = lPartition(arr, li, hi);
        lQSort(arr, li, p-1);
        lQSort(arr, p+1, hi);
    }
}

void hQSort(int arr[], int li, int hi){
    if(li < hi){
        int p = hPartition(arr, li, hi);
        lQSort(arr, li, p);
        lQSort(arr, p+1, hi);
    }
}

void heap_sort(int arr[], int n){
    //Build a max heap..
    build_heap(arr, n);

    for(int i = n-1; i>=1; i--){
        swap(arr[0], arr[i]);

        //Heapify the reduced heap..
        min_heapify(arr, i, 0);
    }  
}

void bubble_sort(int arr[], int n){
    bool SWAP_STAT = false;
    int boundary = n;

    for(int i = 0; i<n; i++){
        for(int j = 0; j<boundary-1; j++){
            if(arr[j] > arr[j+1]){
                swap(arr[j], arr[j+1]);
                SWAP_STAT = true;
            }
        }

        if(!SWAP_STAT) 
            break;
            
        boundary--;
    }
}

void selection_sort(int arr[], int n){
    for(int i = 0; i<n; i++){
        int min_indx = i;

        for(int j = i+1; j<n; j++){
            if(arr[j] < arr[min_indx])
                min_indx = j;
        }

        swap(arr[i], arr[min_indx]);
    }
}

void test1(int arr[], int n){
    int k, j;
    for(int i = 1; i<n; i++){
        k = arr[i], j = i-1;
        while(j>=0 && arr[j] > k){
            arr[j+1] = arr[j];
        }
    }
}

void insertion_sort(int arr[], int n){
    int k, j;
    for(int i = 1; i<n; i++){
        //store the currently iterating element to re-position it into a new position in future(in sorted fashion)
        k = arr[i], j = i-1;

        //compares the previous element's with the currently stored reference number..
        while(j>=0 && arr[j] > k){
            arr[j+1] = arr[j];//moving the larger elements to right-side to make place for placing the previously iterating element `k` in it's desired posiiton.. 
            j--;
        }
        
        //placing the iterating element `k` in it's desired location..
        arr[j+1] = k;

    }
}

void counting_sort(int arr[], int n){
    int k = maxf(arr, n, false)+1;
    int count[k];
    int indx = 0;
    for(int i = 0; i<k; i++){
        count[i] = 0;
    }
    
    for(int i = 0; i<n; i++){
        count[arr[i]]++;
    }

    for(int i = 0; i<k; i++){
        for(int j = 0; j<count[i]; j++){
            arr[indx++] = i;
        }
    }
}

void stable_counting_sort(int arr[], int n){
    int k = maxf(arr, n, false) + 1;
    int count[k], sorted[n];   
    for(int i = 0; i<k; i++){
        count[i] = 0;
    }

    for(int i = 0; i<n; i++){
        count[arr[i]]++;
    }

    for(int i = 1; i<k; i++){
        count[i] = count[i-1] + count[i];
    }

    for(int i = n-1; i>=0; i--){
        sorted[count[arr[i]] - 1] = arr[i];   
        count[arr[i]]--;
    }

    cp_array(sorted, arr, n);

}

void radix_sort(int arr[], int n){
    int mx = maxf(arr, n, false);

    for(int exp = 1; (mx/exp)>0; exp*=10){
        radix_count_sort(arr, exp, n);
    }

}


