//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) mat[i][j] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(mat);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    
    public class Pair {
        int i, j, t;
        
        Pair(int i, int j, int t) {
            this.i = i;
            this.j = j;
            this.t = t;
        }
    }

    public int orangesRotting(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        Queue<Pair> pq = new LinkedList<>();
        int freshCount = 0;
        
        // Step 1: Store initial rotten oranges and count fresh ones
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 2) {
                    pq.add(new Pair(i, j, 0)); // Rotten oranges added to queue
                } else if (mat[i][j] == 1) {
                    freshCount++; // Count fresh oranges
                }
            }
        }

        // If there are no fresh oranges, return 0 immediately
        if (freshCount == 0) return 0;

        int time = 0;
        int[] dx = {1, -1, 0, 0}; // Row movement
        int[] dy = {0, 0, 1, -1}; // Column movement
        
        // Step 2: BFS to rot fresh oranges
        while (!pq.isEmpty()) {
            Pair p1 = pq.poll();
            int i = p1.i, j = p1.j, t = p1.t;
            time = Math.max(time, t); // Update maximum time

            for (int k = 0; k < 4; k++) {
                int ni = i + dx[k], nj = j + dy[k];

                // Check boundary and fresh orange condition
                if (ni >= 0 && ni < n && nj >= 0 && nj < m && mat[ni][nj] == 1) {
                    mat[ni][nj] = 2; // Mark as rotten
                    pq.add(new Pair(ni, nj, t + 1)); // Add to queue with incremented time
                    freshCount--; // Reduce fresh count
                }
            }
        }

        // If there are fresh oranges left, return -1 (impossible to rot all)
        return (freshCount == 0) ? time : -1;
    }
}
