import java.util.Arrays;
import java.util.Scanner;

public class DP_longestStringChain {
    public static boolean valid(String first, String second) {
        if(first.length() != (1 + second.length())) return false;

        int f = 0, s = 0;

        while(f < first.length()) {
            if(s < first.length() && first.charAt(f) == second.charAt(s)) {
                f++; s++;
            }
            else f++;   
        }

        if(f == first.length() && s == second.length()) return true;
        return false;
    }   

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        String[] arr = new String[n];
        int[] dp = new int[n];
        for(int i=0; i<n; ++i) {
            arr[i] = scan.next();
            dp[i] = i;
        }
        Arrays.sort(arr);

        for(int i=0; i<n; ++i) {
            for(int j=0; j<i; ++j) {
                if(dp[i] < 1+dp[j] && valid(arr[i], arr[j])) {
                    dp[i] = 1 + dp[j];
                }
            }
        }

        for(int i=0; i<n; ++i) System.out.print(arr[i] + " ");
        System.out.println();
        for(int i=0; i<n; ++i) System.out.print(dp[i] + " ");

        scan.close();
    }
}
