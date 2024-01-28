import java.util.Scanner;

public class DP_subSetSum {

    // using knapsack 
    public static boolean subsetSumToK(int n, int k, int arr[]){
        boolean[][] dp = new boolean[n][k+1];
        for(int i=0; i<n; ++i) dp[i][0] = true;
        
        if(arr[0]<k) dp[0][arr[0]] = true;
        
        for(int i=1; i<n; ++i) {
            for(int j=1; j<=k; ++j) {
                boolean notpick = dp[i-1][j];
                boolean pick = false;
                if(arr[i] <= j) pick = dp[i-1][j - arr[i]];
                dp[i][j] = notpick | pick;   
            }
        }
        return dp[n-1][k];
    }

    //using recursion
    public static boolean go(int ind, int target, int arr[], Boolean[][] dp) {
        if(target == 0) return true;
        if(ind == 0) return arr[ind] == target;
        
        if(dp[ind][target] != null) return dp[ind][target];
        
        boolean notpick = go(ind-1, target, arr, dp);
        boolean pick = false;
        if(arr[ind] <= target) pick = go(ind-1, target - arr[ind], arr, dp);
        
        return dp[ind][target] = (notpick || pick);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), k = scan.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; ++i) arr[i] = scan.nextInt();

        Boolean[][] dp = new Boolean[n][k+1];
        System.out.println(subsetSumToK(n, k, arr));
        System.out.println(go(n-1, k, arr, dp));

        scan.close();
    }
}
