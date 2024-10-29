#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int N,n,M,m;
    
    cin>> N;
    int* A = new int[N];
    for(int i = 0;i < N;i++){
        cin>>n;
        A[i] = n;
        
    }
    
    cin>> M;
    int* B = new int[M];
    
    for(int i = 0;i < M;i++){
        cin>>m;
        B[i] = m;
    }
    
    sort(A,A+N);
    
    int* C = new int [M];
   
    
    for(int i= 0;i<M;i++){
        C[i]=0;
    }
    
    for(int i = 0;i < M;i++){
        int low = 0;
        int high = N - 1;
        int mid;
        while(low <= high){
            mid = (low+high)/2;
            if(B[i]==A[mid]){
                C[i]=1;
                break;
            }
            else if(B[i] > A[mid]){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
    }
    for(int i= 0;i<M;i++){
        cout<<C[i]<<'\n';
    }
}