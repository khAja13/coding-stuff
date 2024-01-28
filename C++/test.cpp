#include<bits/stdc++.h> 
using namespace std;
int main()
{
    int x, y;
    cin >> x >> y;  // Input the size of two arrays
    int a[x], b[y];
    for(int i=0; i<x; i++)
        cin >> a[i];  // Input the elements of array A
    for(int i=0; i<y; i++)
        cin >> b[i];  // Input the elements of array B

    int dp[x+1][y+1];
    memset(dp, 0, sizeof(dp));
    int res = 0;
    int count = 0;
    for(int i=1; i<=x; i++)
    {
        for(int j=1; j<=y; j++)
        {
            if(a[i-1] == b[j-1])
            {
                dp[i][j] = dp[i-1][j-1]+1;
                if(dp[i][j] > res)
                {
                    res = dp[i][j];
                    count = 1;
                }
                else if(dp[i][j] == res)
                {
                    int l1=i, l2=j;
                    while(l1>0 && l2>0 && a[l1-1]==b[l2-1])
                    {
                        l1--;
                        l2--;
                    }
                    if(l1==0 || l2==0 || a[l1-1]!=b[l2-1])
                        count++;
                }
            }
        }
    }
    cout << count << endl;  // Output the number of unique maximum length sub-sequences
    return 0;
}
