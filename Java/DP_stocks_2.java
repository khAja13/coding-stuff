import java.util.Scanner;

public class DP_stocks_2 {
    public static int go(int[] arr, int ind, int n, boolean buy, int[][] dp) {
        if(ind == n) return 0;

        if(dp[ind][buy?1:0] != -1) return dp[ind][buy?1:0];

        int profit = 0;
        if(buy == true) {
            profit = Math.max(-arr[ind] + go(arr, ind+1, n, false, dp), go(arr, ind+1, n, true, dp));
        }
        else {
            profit = Math.max(arr[ind] + go(arr, ind+1, n, true, dp), go(arr, ind+1, n, false, dp));
        }

        return dp[ind][buy?1:0] = profit;  
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        
        int[] arr = new int[n];
        for(int i=0; i<n; ++i) arr[i] = scan.nextInt();

        int[][] dp = new int[n+1][2];
        for(int i=0; i<=n; ++i) {
            for(int j=0; j<2; ++j) dp[i][j] = -1;
        }
        
        System.out.println("Maximum profit will be " + go(arr, 0, n, true, dp));

        scan.close();
    }
}
