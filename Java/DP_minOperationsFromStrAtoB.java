import java.util.Scanner;

public class DP_minOperationsFromStrAtoB {
    public static int go(String s1, String s2, int one, int two, int[][] dp) {
        if(one < 0 || two < 0) return 0;

        if(dp[one][two] != -1) return dp[one][two];

        if(s1.charAt(one) == s2.charAt(two)) 
            return dp[one][two] = 1 + go(s1, s2, one-1, two-1, dp);

        return dp[one][two] = Math.max(go(s1, s2, one, two-1, dp), go(s1, s2, one-1, two, dp));
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String s1 = scan.next(), s2 = scan.next();
        int first = s1.length(), second = s2.length();

        int[][] dp = new int[first+1][second+1];
        for(int i=0; i<dp.length; ++i) {
            for(int j=0; j<dp[0].length; ++j) dp[i][j] = -1;
        }

        int commonSubSeq = go(s1, s2, first-1, second-1, dp);

        System.out.println(first + second - (2*commonSubSeq));

        scan.close();
    }    
}
