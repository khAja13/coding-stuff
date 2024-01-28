import java.util.Scanner;

public class DP_editDistance {

    public static int go(String s1, String s2, int ind1, int ind2, int[][] dp) {

        if(ind1 < 0) return ind2+1;
        if(ind2 < 0) return ind1+1;

        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];

        if(s1.charAt(ind1) == s2.charAt(ind2)) {
            return dp[ind1][ind2] = go(s1, s2, ind1-1, ind2-1, dp);
        }

        int insert = 1 + go(s1, s2, ind1, ind2-1, dp);
        int delete = 1 + go(s1, s2, ind1-1, ind2, dp);
        int replace = 1 + go(s1, s2, ind1-1, ind2-1, dp);

        return dp[ind1][ind2] = Math.min(insert, Math.min(delete, replace));
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String s1 = scan.next(), s2 = scan.next();

        int first = s1.length(), second = s2.length();

        int[][] dp = new int[first+1][second+1];
        for(int i=0; i<dp.length; ++i) {
            for(int j=0; j<dp[0].length; ++j) dp[i][j] = -1;
        }

        System.out.println(go(s1, s2, first-1, second-1, dp));

        scan.close();
    }
}
