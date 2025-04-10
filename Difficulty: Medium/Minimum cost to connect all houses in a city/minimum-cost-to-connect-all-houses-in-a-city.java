//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] edge = new int[n][2];
            for (int i = 0; i < n; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res = obj.minCost(edge);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {

    public static class Pair {
        int node; 
        int cost;

        Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public int minCost(int[][] houses) {
        int n = houses.length;
        boolean[] visited = new boolean[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        
        pq.offer(new Pair(0, 0)); // start from house 0
        int totalCost = 0;

        while (!pq.isEmpty()) {
            Pair current = pq.poll();

            if (visited[current.node]) continue;

            visited[current.node] = true;
            totalCost += current.cost;

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int dist = Math.abs(houses[current.node][0] - houses[i][0]) + 
                               Math.abs(houses[current.node][1] - houses[i][1]);
                    pq.offer(new Pair(i, dist));
                }
            }
        }

        return totalCost;
    }

    // For testing purpose
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] houses = {{0, 7}, {0, 9}, {20, 7}, {30, 7}, {40, 70}};
        System.out.println("Minimum cost to connect all houses: " + sol.minCost(houses));
    }
}

