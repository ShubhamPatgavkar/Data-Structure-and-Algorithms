//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {

            int V = Integer.parseInt(read.readLine().trim());
            int E = Integer.parseInt(read.readLine().trim());

            int[][] edges = new int[E][3];

            for (int i = 0; i < E; i++) {
                String[] parts = read.readLine().trim().split(" ");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);
                int w = Integer.parseInt(parts[2]);

                edges[i][0] = u;
                edges[i][1] = v;
                edges[i][2] = w;
            }

            // Read source vertex
            int S = Integer.parseInt(read.readLine().trim());

            Solution ob = new Solution();
            int[] ptr = ob.bellmanFord(V, edges, S);

            // Print the result
            for (int i = 0; i < ptr.length; i++) {
                System.out.print(ptr[i] + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // Initialize distances with "infinity" (use Integer.MAX_VALUE)
        int[] dis = new int[V];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0; // Distance to the source is 0
        
        // Relax all edges (V-1) times
        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                // Relaxation step
                if (dis[u] != Integer.MAX_VALUE && dis[u] + w < dis[v]) {
                    dis[v] = dis[u] + w;
                }
            }
        }
        
        // Check for negative weight cycles (V-th iteration)
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            // If we can relax an edge in the V-th iteration, there's a negative cycle
            if (dis[u] != Integer.MAX_VALUE && dis[u] + w < dis[v]) {
                return new int[]{-1}; // Negative cycle detected
            }
        }
        
          for (int i = 0; i < V; i++) {
            if (dis[i] == Integer.MAX_VALUE) {
                dis[i] = 100000000; // 10^8 for unreachable vertices
            }
        }
        
        return dis; // Return the final distances
    }
}

