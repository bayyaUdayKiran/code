# include <iostream>
# include "Lib/headers/utility.h"
# include "Lib/headers/sort.h"

using namespace std;
int main(){
    int a[8] = {5, 25, 2, 7, 8, 9, 3, 1};
    radix_sort(a, 8);
    print_array(a, 8);
    return 0;
}

