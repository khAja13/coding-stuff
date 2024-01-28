#include <bits/stdc++.h>
using namespace std;

int denominations[7] = {100,50,20,10,5,2,1};
int noteCount[7] = {0,0,0,0,0,0,0};

int Validate(int amount) {
    if(amount > 0) return 1;
    return 0;
}

int DenominationsCount(int amount) {
    for (int i = 0; i < 7; i++) {
        if (amount >= denominations[i]) {
            noteCount[i] = amount / denominations[i];
            amount = amount % denominations[i];
        }
    }
    return 1;
}

int main() {

    int amt, i;
    cin>>amt;

    if(Validate(amt)) {
        if(DenominationsCount(amt)) {
            for(i=0; i<7; ++i) {
                cout << denominations[i] << "s= " << noteCount[i] << endl;
            }
        }
    }
    
    return 0;
}