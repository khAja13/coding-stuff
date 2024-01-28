import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class REC_printSubSequenceArr {
    public static void go(int ind, int[] arr, List<Integer> list) {
        if(ind >= arr.length) {
            for(int i : list) System.out.print(i + " "); 
            System.out.println();
            return;
        }
        list.add(arr[ind]);
        go(ind+1, arr, list);
        list.remove(list.size()-1);   
        go(ind+1, arr, list);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int[] arr = new int[n];
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; ++i) arr[i] = scan.nextInt();

        go(0, arr, list);

        scan.close();
    }
}