#include <bits/stdc++.h>
using namespace std;

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    string s;
    cin >> s;
    int arr[26] = {};
    
    for(int i=0;i < s.length();i++){
        arr[s[i]-'a']++;
    }
    for(int i=0;i<26;i++){
        cout<<arr[i]<<" ";
    }
}