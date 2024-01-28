import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {
    public static void go(int n, int open, int close, List<String> ans, String str) {
        System.out.println(open + " " + close + " " + str);
        if(str.length() == n*2) {
                ans.add(str);
                System.out.println(str);
            return;
        }   
        
        if(open < n-1) {
            str += '(';
            go(n, open+1, close, ans, str);
        }
        if(close <= open) {
            str += ')';
            go(n, open, close+1,  ans, str);
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        List<String> ans = new ArrayList<>();
        
        go(n,0,0,ans,"");
        scan.close();
    }
}
