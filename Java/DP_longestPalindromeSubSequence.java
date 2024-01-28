import java.util.Scanner;

public class DP_longestPalindromeSubSequence {
    public static int go(String str1, String str2, int first, int second) {
        if(first < 0 || second < 0) return 0;

        if(str1.charAt(first) == str2.charAt(second)) {
            return 1 + go(str1, str2, first-1, second-1);
        }

        return Math.max(go(str1, str2, first, second-1), go(str1, str2, first-1, second));
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String str = scan.next();

        System.out.println("Longest palindromic subsequence length is " + go(str, new StringBuilder(str).reverse().toString(), str.length()-1, str.length()-1));
        scan.close();
    }    
}
