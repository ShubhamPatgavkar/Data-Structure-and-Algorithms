//{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int V = Integer.parseInt(br.readLine().trim());
            int E = Integer.parseInt(br.readLine().trim());
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                String[] s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));

            ot.println("~");
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static class Pair{
        int d;
        int w;
        
        Pair(int d, int w){
            this.d = d;
            this.w = w;
        }
    }
    
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.w,b.w));
        boolean vis[] = new boolean[V];
        int total = 0;
        
        pq.add(new Pair(0,0));
        
        while(!pq.isEmpty()){
            Pair p1 = pq.poll();
            if(vis[p1.d])continue;
            vis[p1.d] = true;
            total += p1.w;
            
            
            for(int arr[] : adj.get(p1.d)){
                int n = arr[0];
                int w = arr[1];
                
                if(!vis[n]){
                    pq.add(new Pair(n, w));
                }
            }
        }
        
        return total;
    }
}