import java.util.Scanner;

public class DP_longestIncSubSequence_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; ++i) arr[i] = scan.nextInt();

        int[] dp = new int[n];
        for(int i=0; i<n; ++i) dp[i] = 1;
        int max = -1;
        
        for(int i=0; i<n; ++i) {
            for(int j=0; j<i; ++j) {
                if(arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        scan.close();
    }
}


