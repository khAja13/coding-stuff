import java.util.Scanner;

public class knapsack {

    public static int knap(int ind, int W, int[] weights, int[] values, int[][] dp) {
        if(ind < 0 || W < 0) return 0;

        if(dp[ind][W] != -1) return dp[ind][W];

        int notpick = knap(ind-1, W, weights, values, dp);
        int pick = 0;
        if(weights[ind] <= W) pick = values[ind] + knap(ind-1, W-weights[ind], weights, values, dp);

        return dp[ind][W] = Math.max(notpick, pick);
    }

    public static int go(int[] weights, int[] values, int W, int n) {
        int[][] dp = new int[n][W+1];

        for(int i=0; i<n; ++i) {
            for(int j=0; j<=W; ++j) {
                if(i == 0 || j == 0) dp[i][j] = 0;
                else {
                    if(weights[i-1] <= j) {
                        dp[i][j] = Math.max(values[i-1] + dp[i-1][j-weights[i-1]], dp[i-1][j]);
                    }
                    else dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n-1][W];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt(), W = scan.nextInt();
        int[] weights = new int[n], values = new int[n];

        for(int i=0; i<n; ++i) weights[i] = scan.nextInt();
        for(int i=0; i<n; ++i) values[i] = scan.nextInt();

        int[][] dp = new int[n][W+1];
        for(int i=0; i<n; ++i) {
            for(int j=0; j<=W; ++j) dp[i][j] = -1;
        }

        System.out.println(knap(n-1, W, weights, values, dp));
        System.out.println(go(weights, values, W, n));

        scan.close();
    }
}
