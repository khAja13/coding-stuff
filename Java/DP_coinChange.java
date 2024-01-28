import java.util.Scanner;

//what is the minimum coins needed to make that amount
public class DP_coinChange {

    public static int go(int ind, int arr[], int target) {
        if(ind == 0) return target%arr[ind] == 0 ? target/arr[ind] : (int)1e9;

        int notpick = go(ind-1, arr, target);
        int pick = Integer.MAX_VALUE;
        if(arr[ind] <= target) pick = 1 + go(ind, arr, target - arr[ind]);

        return Math.min(notpick, pick);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt(), target = scan.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; ++i) arr[i] = scan.nextInt();

        System.out.println(go(n-1, arr, target));

        scan.close();
    }
}
