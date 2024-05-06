#include<iostream>  
#include<vector>
# include <string>

using namespace std;  


 vector<string> fizzBuzz(int n) {
        vector<string> res;
        res.resize(n);
        for(int i = 1; i<=n; i++){
            if(i%3 == 0){
                if(i%5 == 0)
                    res[i] = "Fizzbuzz";
                else
                    res[i] = "Fizz";

            }else if(i%5 == 0)
                res[i] = "Buzz";

            else
                res[i] = to_string(i);   
        }
        return res;
}
int main(){
    vector<string> res = fizzBuzz(3);
    for(int i = 1; i<=3; i++){
        cout << res[i] << " ";
    }
    return 0;
}