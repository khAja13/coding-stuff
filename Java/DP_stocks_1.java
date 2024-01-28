import java.util.Scanner;

public class DP_stocks_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        
        int[] arr = new int[n];
        for(int i=0; i<n; ++i) arr[i] = scan.nextInt();

        int min = arr[0], profit = 0;
        for(int i=1; i<n; ++i) {
            min = Math.min(min, arr[i]);
            profit = Math.max(arr[i] - min, profit);
        }

        System.out.println("Maximum profit will be " + profit);
        scan.close();
    }
}
