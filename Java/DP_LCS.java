import java.util.Scanner;

public class DP_LCS {
    public static int go(String str1, String str2, int index1, int index2, int[][] dp) {
        if(index1 < 0 || index2 < 0) return 0;

        if(dp[index1][index2] != -1) return dp[index1][index2];

        if(str1.charAt(index1) == str2.charAt(index2)) return dp[index1][index2] = 1 + go(str1, str2, index1-1, index2-1, dp);

        return dp[index1][index2] = Math.max(go(str1, str2, index1, index2-1, dp), go(str1, str2, index1-1, index2, dp));
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.next(), str2 = scan.next();

        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for(int i=0; i<dp.length; ++i) {
            for(int j=0; j<dp[0].length; ++j) dp[i][j] = -1;
        }

        System.out.println("[RECURSION AND MEMOIZATION] Longest common subsequence is " + go(str1, str2, str1.length()-1, str2.length()-1, dp));

        for(int i=0; i<dp.length; ++i) {
            for(int j=0; j<dp[0].length; ++j) {
                if(i == 0 || j == 0) dp[i][j] = 0;
            }
        }

        for(int i=1; i<dp.length; ++i) {
            for(int j=1; j<dp[0].length; ++j) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        System.out.println("[TABULATION] Longest common subsequence is " + dp[str1.length()][str2.length()]);

        scan.close();
    }
}
