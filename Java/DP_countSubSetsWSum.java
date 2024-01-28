import java.util.Scanner;

public class DP_countSubSetsWSum {

    public static int go(int index, int tar, int[] arr, int[][] dp) {

        //if arr[i] range is from 0
        if(index == 0) {
            if(arr[index] == 0 && tar == 0) return 2;
            if(arr[index] == tar || tar == 0) return 1;
            return 0;
        }

        //if arr[i] range is from 1
        // if(tar == 0) return 1;
        // if(index == 0) return arr[index] == tar ? 1 : 0;

        if(dp[index][tar] != -1) return dp[index][tar];
        
        int notpick = go(index-1, tar, arr, dp);
        int pick = 0;
        if(arr[index] <= tar) pick = go(index-1, tar - arr[index], arr, dp);
        
        return dp[index][tar] = (notpick + pick);
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), target = scan.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; ++i) arr[i] = scan.nextInt();

        int[][] dp = new int[n][target+1];
        for(int i=0; i<n; ++i) {
            for(int j=0; j<=target; ++j) dp[i][j] = -1;
        }

        System.out.println(go(n-1, target, arr, dp));

        scan.close();
    }
}
