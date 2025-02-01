//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] mat = new char[n][m];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.next().charAt(0);
                }
            }

            String word = sc.next();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(mat, word);
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {

    // Helper function for DFS
    static boolean dfs(char[][] mat, int i, int j, int k, String word, boolean[][] visited) {
        // Base cases: Out of bounds or character mismatch or already visited
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || visited[i][j] || mat[i][j] != word.charAt(k)) {
            return false;
        }

        // If we reached the end of the word, return true
        if (k == word.length() - 1) {
            return true;
        }

        // Mark current cell as visited
        visited[i][j] = true;

        // Explore all four possible directions
        boolean found = dfs(mat, i + 1, j, k + 1, word, visited) ||
                        dfs(mat, i - 1, j, k + 1, word, visited) ||
                        dfs(mat, i, j + 1, k + 1, word, visited) ||
                        dfs(mat, i, j - 1, k + 1, word, visited);

        // Unmark current cell (backtracking)
        visited[i][j] = false;

        return found;
    }

    // Function to check if word exists in the matrix
    static public boolean isWordExist(char[][] mat, String word) {
        int rows = mat.length, cols = mat[0].length;
        boolean[][] visited = new boolean[rows][cols];

        // Try starting DFS from every cell that matches the first character of the word
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == word.charAt(0)) {
                    if (dfs(mat, i, j, 0, word, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}