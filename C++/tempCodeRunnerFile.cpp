#include <bits/stdc++.h>
using namespace std;

int go(string str, set<int> set) {
    int count = 0;
    for(char i : str) {
        auto val = set.find(i);
        if(val != set.end()) count++; 
    }
    return count;
}

int main() {

    string str1, str2;
    cin>>str1;
    cin>>str2;

    set<int> set;
    set.insert('A');
    set.insert('B');
    set.insert('D');
    set.insert('O');
    set.insert('P');
    set.insert('Q');
    set.insert('R');

    int one = go(str1, set);
    int two = go(str2, set);

    if(one > two) cout <<  "Tony wins the game" << endl;
    else if(one < two) cout <<  "Henry wins the game" << endl;
    else cout << "Equal points" << endl;
    
    return 0;
}