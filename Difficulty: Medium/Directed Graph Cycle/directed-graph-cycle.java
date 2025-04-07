//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.isCyclic(V, edges);
            System.out.println(ans ? "true" : "false");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    
    public boolean dfs(int adj[][] , boolean pathvis[] , boolean vis[], int i){
        vis[i] = true;
        pathvis[i] = true;
        
        for(int j=0; j<adj.length; j++){
            if(adj[i][j] == 1){
               
               if(!vis[j]){
                   if(dfs(adj, pathvis, vis, j)) return true;
               }else if (pathvis[j]){
                   return true;
               }
            
                
            }
        }
        
        pathvis[i] = false;
        return false;
    }
    
    public boolean isCyclic(int V, int[][] edges) {
       boolean pathvis[] = new boolean [V];
       boolean vis[] = new boolean[V];
       int adj[][] = new int[V][V];
       
       for(int edge[] : edges){
           int i = edge[0];
           int j = edge[1];
       
           adj[i][j] = 1;
       }
       
       for(int i=0; i<V; i++){
         if(!vis[i]){
                if (dfs(adj, pathvis,vis, i)) return true;
          }
        }
        
        return false;   
       }
}