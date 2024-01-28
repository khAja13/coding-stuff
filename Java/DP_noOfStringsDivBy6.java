import java.util.Scanner;

// Number of substrings in a string divisible by 6

public class DP_noOfStringsDivBy6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String num = scan.next();
        int count = 0;

        for(int i=0; i<num.length(); ++i) {
            int rem = 0;
            for(int j=i; j<num.length(); ++j) {
                int val = num.charAt(j) - '0';
                if(val == 0 && i==j) {
                    count++;
                    break;
                }
                if(val%2 == 0 && (val+rem)%3 == 0) {
                    count++;
                }
                rem = (val+rem)%3;
            }
        }

        System.out.println(count);

        scan.close();
    }
}
