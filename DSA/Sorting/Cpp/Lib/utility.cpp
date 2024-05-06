# include <iostream>
# include <cstdlib>
# include <ctime>
# include "headers/utility.h"
# include "headers/sort.h"

using namespace std;


void populate_array(int arr[], int n){
    cout << n;
    for(int i = 0; i<n; i++){
        cout << "array[" << i << "]: ";
        cin >> arr[i];
    }
}

void print_array(int arr[], int n){
    cout << '[';
    for(int i = 0; i<n; i++){
        if(i!=n-1)
            cout << arr[i] << ", ";
        else
            cout << arr[i];
    }
    cout << ']' << endl;
}



int maxf(int arr[], int n, bool indx){
    int mx = arr[0], mx_indx;
    for(int i = 1; i<n; i++){
        if(arr[i] > mx){
            mx = arr[i];
            mx_indx = i;
        }       
    }

    if(indx)
        return mx_indx;
    else
        return mx;
}

int minf(int arr[], int n, bool indx){
    int mn = arr[0], mn_indx = 0;
    for(int i = 1; i<n; i++){
        if(arr[i]<mn){
            mn = arr[i];
            mn_indx = i;
        }
    }

    if(indx)
        return mn_indx;
    else
        return mn;
}

void cp_array(int src[], int dest[], int n){
    for(int i = 0; i<n; i++){
        *(dest+i) = *(src+i);
    }
}

int** split_array(int arr[], int mid, int n){
    int col1 = mid, col2 = n - mid, col;

    int** res = new int*[2];
    int k = 0;
    for(int i = 0; i < 2; i++){
        res[i] = new int[i == 0 ? col1 : col2];
        for(int j = 0; j < (i == 0 ? col1 : col2); j++, k++){
            //res[i][j] = arr[k];
            *(*(res+i)+j) = arr[k];
        }
    }

    return res;
}

bool is_sorted(int arr[], bool rev, int n){

    for(int i = 1; i<n; i++){
        if(arr[i-1]>arr[i] && !rev)
            return false;
            
        else if(arr[i-1]<arr[i] && rev)
            return false;
    }
    return true;
}

int* merge(int l[], int r[], int ln, int rn){
    //int res[ln+rn];
    int* res = new int[ln+rn];
    int k = 0, i = 0, j = 0;
    
    while(i<ln && j<rn){
        if(l[i]<r[j]){
            res[k++] = l[i++];
        }else{
            res[k++] = r[j++];
        }
    }

    while(i<ln){
        res[k++] = l[i++];
    }

    while(j<rn){
        res[k++] = r[j++];
    }

    return res;
}

void merge(int arr[], int  li, int ri, int mid, int n){
    int* temp = new int[ri - li + 1];
    int i = li, j = mid+1, k = 0;

    while(i <= mid && j <= ri){
        if(arr[i] <= arr[j])
            temp[k++] = arr[i++];
        else
            temp[k++] = arr[j++];
    }

    while(i <= mid){
        temp[k++] = arr[i++];
    }

    while(j <= ri){
        temp[k++] = arr[j++];
    }

    for(int p = li, q = 0; q<(ri-li+1); p++, q++){
        arr[p] = temp[q];
    }
    
}

int max_digit(int arr[], int n){
    int largest = maxf(arr, n, false), mxdgt = 0, digit;

    for(int exp = 1; largest/exp > 0; exp*=10){
        for(int j = 0; j<n; j++){
            digit = arr[j]/exp % 10;
            if(digit>mxdgt)
                mxdgt = digit;  
        }
    }

    return mxdgt;
}

void naive_partition(int arr[], int li, int hi, int pi){
    int temp[hi-li+1];
    int k = 0, pivot = arr[pi];

    for(int i = li; i<=hi; i++){
        if(arr[i]<pivot)
            temp[k++] = arr[i];
    }

    temp[k++] = pivot;

    for(int i = li; i<=hi; i++){
        if(arr[i]>pivot)
            temp[k++] = arr[i];
    }


    for(int p = li, q = 0; q<(hi-li+1); p++, q++){
        arr[p] = temp[q];
    }

}

int lPartition(int arr[], int li, int hi){
    int pivot = arr[hi], pi = li;

    for(int i = li; i<=hi; i++){
        if(arr[i]<pivot){
            swap(arr[i], arr[pi++]);
        }
    }
    swap(arr[hi], arr[pi]);
    return pi;

}

int hPartition(int arr[], int li, int hi){
    int pivot = arr[li], i = li-1, j = hi+1;
    while (true){
        do{
            i++;
        }while(arr[i] < pivot);

        do{
            j--;
        }while(arr[j] > pivot);

        if(i>=j)
            return j;

        swap(arr[i], arr[j]);

    }
    return -1;
}


void max_heapify(int arr[], int n, int i) {
    int max = i;
    int li = (2*i) + 1, ri = (2*i) + 2;

    if(li < n && arr[li] > arr[max])
        max = li;

    if(ri < n && arr[ri] > arr[max])
        max = ri;

    if(max != i){
        swap(arr[i], arr[max]);
        max_heapify(arr, n, max);
    }   
}

void min_heapify(int arr[], int n, int i){
    int min = i;
    int li = (2*i) + 1, ri = (2*i) + 2;

    if(li < n && arr[li] < arr[min])
        min = li;

    if(ri < n && arr[ri] < arr[min])
        min = ri;

    if(min != i){
        swap(arr[i], arr[min]);
        min_heapify(arr, n, min);
    }   
}

void build_heap(int arr[], int n){
    for(int i = (n/2) - 1; i>=0; i--){
        min_heapify(arr, n, i);
    }
}

int naive_duplicate_count(int arr[], int n){
    int count = 0;
    int cp_arr[n];
    cp_array(arr, cp_arr, n);

    for(int i = 0; i<n; i++){
        //skip the iteration if the pivotal element is already marked as a duplicate..
        if(cp_arr[i] == -1)
            continue;
        for(int j = 0; j<n; j++){
            //compares the pivotal element with all the other elements to check for it's doppleganger..
            if(cp_arr[i] == cp_arr[j] && i != j){
                count++;//count's number of dopplegangers(duplicates)..
                cp_arr[j] = -1;//marks the doppleganger..
            }
        }
    }

    return count;
    
}

int duplicate_count(int arr[], int n){
    lQSort(arr, 0, n-1);
    int count = 0;
    for(int i = 1; i<n; i++){
        if(arr[i] == arr[i-1])
            count++;
    }

    return count;
}

int min_diff(int arr[], int n){
    int diff = INT16_MAX;
    lQSort(arr, 0, n-1);

    if(n == 1)
        return diff;

    for(int i = n-1; i>0; i-=2){
        diff = min((arr[i] - arr[i-1]), diff);
    }

    return diff;
}

void radix_count_sort(int arr[], int exp, int n){
    int k = maxf(arr, n, false) + 1;
    int sorted[n], count[k];
    for(int i = 0; i<k; i++){
        count[i] = 0;
    }

    for(int i = 0; i<n; i++){
        count[(arr[i]/exp)%10]++;
    }

    for(int i = 1; i<k; i++){
        count[i] = count[i-1] + count[i];
    }

    for(int i = n-1; i>=0; i--){
        sorted[count[(arr[i]/exp)%10] - 1] = arr[i];
        count[(arr[i]/exp)%10]--;
    }

    cp_array(sorted, arr, n);
}
