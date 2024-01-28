import java.util.Scanner;

public class DP_minInsertionsToPalindrome {

    public static int go(String s1, String s2, int one, int two, int[][] dp) {
        if(one < 0 || two < 0) return 0;
        
        if(dp[one][two] != -1) return dp[one][two];
        
        if(s1.charAt(one) == s2.charAt(two)) 
            return dp[one][two] = 1 + go(s1, s2, one-1, two-1, dp);
        
        return dp[one][two] = Math.max(go(s1, s2, one, two-1, dp), go(s1, s2, one-1, two, dp));
    } 

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String str = scan.next();
        int n = str.length();

        int[][] dp = new int[n+1][n+1];
        for(int i=0; i<=n; ++i) {
            for(int j=0; j<=n; ++j) dp[i][j] = -1;
        }

        int palLen = go(str, new StringBuilder(str).reverse().toString(), n-1, n-1, dp);

        System.out.println("Minimum insertions to make a string palindrome is " + (n - palLen));
        scan.close();
    }    
}
