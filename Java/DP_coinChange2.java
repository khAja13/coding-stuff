import java.util.Scanner;

//count in how many ways u can make that amount 
public class DP_coinChange2 {
    public static int go(int index, int[] coins, int amount, int[][] dp) {
        if(index == 0) return amount % coins[index] == 0 ? 1 : 0;
        
        if(dp[index][amount] != -1) return dp[index][amount];
        
        int notpick = go(index-1, coins, amount, dp);
        int pick = 0;
        if(coins[index] <= amount) pick = go(index, coins, amount-coins[index], dp);
        
        return dp[index][amount] = notpick + pick;
    }
        
    public static int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        
        for(int i=0; i<coins.length; ++i) {
            for(int j=0; j<=amount; ++j) dp[i][j] = -1;
        }
        
        return go(coins.length-1, coins, amount, dp);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt(), amount = scan.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; ++i) arr[i] = scan.nextInt();

        System.out.println(change(amount, arr));

        scan.close();
    }
}
