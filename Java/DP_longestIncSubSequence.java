import java.util.Scanner;

public class DP_longestIncSubSequence {
    public static int go(int ind, int prev, int[] arr, int[][] dp) {

        System.out.println(prev + " " + ind);

        if(ind >= arr.length) return 0;

        if(dp[ind][prev+1] != -1) return dp[ind][prev+1];

        if(prev == -1 || arr[ind] > arr[prev]) {
            int pick = 1 + go(ind+1, ind, arr, dp);
            int notpick = go(ind+1, prev, arr, dp);
            return dp[ind][prev+1] = Math.max(pick, notpick);
        }
        
        return dp[ind][prev+1] = go(ind+1, prev, arr, dp);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int[] arr = new int[n];
        int[][] dp = new int[n+1][n+1];
        for(int i=0; i<n; ++i) arr[i] = scan.nextInt();

        for(int i=0; i<dp.length; ++i) {
            for(int j=0; j<dp[0].length; ++j) dp[i][j] = -1;
        }

        System.out.println(go(0, -1, arr, dp));

        scan.close();
    }
}


