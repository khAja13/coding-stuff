import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class floodFill {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int row = scan.nextInt(), col = scan.nextInt();
        int[][] image = new int[row][col];
        for(int i=0; i<row; ++i) {
            for(int j=0; j<col; ++j) image[i][j] = scan.nextInt();
        }
        int sr = scan.nextInt(), sc = scan.nextInt();
        int newColor = scan.nextInt();

        Queue<int[]> q = new LinkedList<>();
        int[][] arr = {{1,0},{-1,0},{0,1},{0,-1}};
        int rows = image.length, cols = image[0].length;
        
        int thecolor = image[sr][sc];
        image[sr][sc] = newColor;
        
        q.add(new int[]{sr,sc});
        
        while(!q.isEmpty()) {
            int size = q.size();
            System.out.println(size);
            for(int i=0; i<size; ++i) {
                int[] top = q.remove();
                for(int ind=0; ind<=3; ++ind) {
                    int x = top[0]+arr[ind][0], y = top[1]+arr[ind][1];
                    if(x<0 || y<0 || x==rows || y==cols || image[x][y]!=thecolor || image[x][y]==newColor) continue;
                    image[x][y] = newColor;
                    q.add(new int[]{x, y});
                }
            }
            
        }

        for(int i=0; i<row; ++i) {
            for(int j=0; j<col; ++j) System.out.print(image[i][j] + " ");
            System.out.println();
        }
        
        scan.close();
    }
}




