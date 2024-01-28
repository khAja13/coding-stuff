import java.util.*;
import java.util.LinkedList;

public class rottenOranges {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int rows = scan.nextInt(), cols = scan.nextInt();
        int fresh = 0, count = 0;
        int[][] grid = new int[rows][cols];
        for(int i=0; i<rows; ++i) {
            for(int j=0; j<cols; ++j) grid[i][j] = scan.nextInt();
        }

        Queue<int[]> q = new LinkedList<>();
        int[][] arr = {{1,0},{-1,0},{0,1},{0,-1}};
        
        for(int i=0; i<rows; ++i) {
            for(int j=0; j<cols; ++j) {
                if(grid[i][j] == 2) q.add(new int[]{i, j});
                else if(grid[i][j] == 1) fresh++;
            }
        }
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int ind=0; ind<size; ++ind) {
                int[] top = q.remove();
                for(int i=0; i<4; ++i) {
                    int x = top[0]+arr[i][0], y = top[1]+arr[i][1];
                    if(x<0 || y<0|| x==rows || y==cols || grid[x][y]==0 || grid[x][y]==2) continue;
                    grid[x][y]=2;
                    q.add(new int[]{x, y});
                    fresh=fresh-1;
                }
            }
            count = count+1;
        }

        System.out.println(fresh == 0 ? count-1 : -1);
        scan.close();
    }
}
