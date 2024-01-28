import java.util.Scanner;

public class DP_longestCommonSubString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.next(), str2 = scan.next();
        int max = 0;

        int[][] dp = new int[str1.length()+1][str2.length()+1];

        for(int i=0; i<dp.length; ++i) {
            for(int j=0; j<dp[0].length; ++j) {
                if(i == 0 || j == 0) dp[i][j] = 0;
            }
        }

        for(int i=1; i<dp.length; ++i) {
            for(int j=1; j<dp[0].length; ++j) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    max = Math.max(max, dp[i][j]);
                }
                else {
                    dp[i][j] = 0;
                }
            }
        }
        System.out.println("[TABULATION] Longest common substring is " + max);

        scan.close();
    }
}

