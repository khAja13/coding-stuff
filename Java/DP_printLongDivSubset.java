import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DP_printLongDivSubset {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt(), max = -1, maxIndex = 0;
        List<Integer> list = new ArrayList<>();
        
        int[] arr = new int[n];
        int[] dp = new int[n];
        int[] hash = new int[n];
        for(int i=0; i<n; ++i) {
            arr[i] = scan.nextInt();
            dp[i] = 1;
            hash[i] = i;
        }

        Arrays.sort(arr);

        for(int i=0; i<n; ++i) {
            for(int j=0; j<i; ++j) {
                if(arr[i] % arr[j] == 0 && dp[i] < 1 + dp[j]) {
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }
            if(max < dp[i]) {
                max = dp[i];
                maxIndex = i;
            }
        }
        for(int i : arr) System.out.print(i + " ");
        System.out.println();
        for(int i : dp) System.out.print(i + " ");
        System.out.println();
        for(int i : hash) System.out.print(i + " ");
        System.out.println();
        System.out.println(max + " " + maxIndex);
        
        while(maxIndex != hash[maxIndex]) {
            list.add(arr[maxIndex]);
            maxIndex = hash[maxIndex];
        }
        list.add(arr[maxIndex]);
        Collections.reverse(list);

        System.out.println(list);

        scan.close();
    }
}
