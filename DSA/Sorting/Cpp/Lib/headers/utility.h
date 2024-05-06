#ifndef UTILITY_H
#define UTILITY_H

void populate_arrayrray(int arr[], int n);
void print_array(int arr[], int n);
int maxf(int arr[], int n, bool indx);
int minf(int arr[], int n, bool indx);
void cp_array(int src[], int dest[], int n);
int** split_array(int arr[], int mid, int n);
bool is_sorted(int arr[], bool rev, int n);
int* merge(int l[], int r[], int ln, int rn);
void merge(int arr[], int li, int ri, int mid, int n);
int max_digit(int arr[], int n);
void naive_partition(int arr[], int li, int hi, int pi);
int lPartition(int arr[], int li, int hi);
int hPartition(int arr[], int li, int hi);
void build_heap(int arr[], int li, int hi);
void max_heapify(int arr[], int n, int i);
void min_heapify(int arr[], int n, int i);
void build_heap(int arr[], int n);
int naive_duplicate_count(int arr[], int n);
int duplicate_count(int arr[], int n);
int min_diff(int arr[], int n);
void radix_count_sort(int arr[], int exp, int n);

#endif