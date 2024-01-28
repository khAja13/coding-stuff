import java.util.*;

public class Solution {
    
    static Map<Integer, Integer> hs = new HashMap<>();
    static HashSet<Character> set = new HashSet<>();
    public static void countDis(String s) {
        for(int i=0; i<s.length(); ++i) {
            for(int j=0; j<=i; ++j) {
                set.add(s.charAt(j));
            }
            hs.put(i, set.size());
        }
    }
    
    public static void isPrime(HashSet<Integer> hash, int N) {
        
        for(int i=2; i<=N; ++i) {
            int count = 0;
            for(int j=1; j<=i; ++j) {
                if(i%j == 0) count++;
            }
            if(count == 2) hash.add(i);
        }

    } 
    

    public static int solve(int N, String S) {
        // code here
        int count = 0;
        HashSet<Integer> hash = new HashSet<>();
        isPrime(hash, S.length());
        countDis(S);
        System.out.println(hs);
        System.out.println(hash);
        System.out.println("in loop");
        for(int i=0; i<N; ++i) {
            if(i%2 == 0 && hash.contains(hs.get(i))) {
                System.out.println("inside");
                count++;
            }
        }
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        solve(43, "mpfkxnmktwujifrnogcyebhcferhlywefzijpypnasz");
        // solve(2, "gg");
    }
}
        
