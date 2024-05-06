# include <iostream>
# include <cmath>

using namespace std;

int bin[32], res_arr[32];

int* rev_array(int* arr, int n){
    
    for(int i = n-1, j = 0; i>=0; i--, j++)
        res_arr[j] = arr[i];
    
    return res_arr;
}

int* dec_to_bin(int dec){
    int val = 0;
    for(int i = 0; i<32; i++)
        bin[i] = 0;

    for(int i = 31; i>=0; i--){
        if(pow(2, i) <= (dec-val)){
            val+=pow(2, i);
            bin[i]++;
        }

    }

    return rev_array(bin, 32);
}

int main(){
    int* res = dec_to_bin(7);

    for(int i = 0; i<32; i++)
        cout << *(res+i);
    cout << endl;
    return 0;
}