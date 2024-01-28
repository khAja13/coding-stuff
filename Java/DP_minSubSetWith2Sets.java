import java.util.Scanner;

public class DP_minSubSetWith2Sets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), sum=0;

        int[] arr = new int[n];
        for(int i=0; i<n; ++i) {
            arr[i] = scan.nextInt();
            sum = sum + arr[i];
        }

        boolean[][] dp = new boolean[n][sum+1];
        for(int i=0; i<n; ++i) dp[i][0] = true;
        
        if(arr[0]<sum) dp[0][arr[0]] = true;
        
        for(int i=1; i<n; ++i) {
            for(int j=1; j<=sum; ++j) {
                boolean notpick = dp[i-1][j];
                boolean pick = false;
                if(arr[i] <= j) pick = dp[i-1][j - arr[i]];
                dp[i][j] = notpick | pick;   
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<=sum; ++i) {
            if(dp[n-1][i] == true) {
                ans = Math.min(ans, Math.abs(i - (sum-i)));
            }
        }

        System.out.println(ans);

        scan.close();
    }
}
