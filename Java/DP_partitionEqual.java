import java.util.Scanner;

public class DP_partitionEqual {
    public static boolean go(int ind, int[] arr, int sum, Boolean[][] dp) {
        if(sum == 0) return true;
        if(ind == 0) return sum == arr[0];

        if(dp[ind][sum] != null) return dp[ind][sum];

        boolean notpick = go(ind-1, arr, sum, dp);
        boolean pick = false;
        if(arr[ind] <= sum) pick = go(ind-1, arr, sum-arr[ind], dp);

        return dp[ind][sum] = (notpick || pick);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), sum=0;
        int[] arr = new int[n];

        for(int i=0; i<n; ++i) {
            arr[i] = scan.nextInt();
            sum = sum + arr[i];
        }

        if(sum%2 == 1) System.out.println("Cant make equal partitions");
        else {
            sum = sum/2;
            Boolean[][] dp = new Boolean[n][sum+1];

            System.out.println(go(n-1, arr, sum, dp));
        }

        scan.close();
    }
}
