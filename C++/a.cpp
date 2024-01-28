#include <bits/stdc++.h>
using namespace std;

string substr(string s, int a, int b) {
    string str = "";
    for(int i=a; i<=b; ++i) str+=s[i];
    return str;
}

int main() {

    string s; cin>>s;
    string str = s.substr(0,3);
    bool DNA = false;

    if(str == "000") DNA = true;

    string ans = "";
    for(int i=3; i<s.length(); i+=3) {
        string val = substr(s, i, i+2);
        if(val == "001") ans += 'C';
        else if(val == "010") ans += 'G';
        else if(val == "011") ans += 'A';
        else if(val == "101" || val == "110") {
            if(DNA) ans += 'T';
            else ans += 'U';
        } 
    }

    cout << ans;
    return 0;
}