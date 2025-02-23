//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            System.out.println(new Solution().countSubstr(s, k));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int countSubstr(String s, int k) {
        // Helper function to count substrings with at most `k` distinct characters
        return atMostKDistinct(s, k) - atMostKDistinct(s, k - 1);
    }

    private int atMostKDistinct(String s, int k) {
        if (k < 0) return 0; // Edge case: no substrings if k is negative

        int l = 0, r = 0, ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();

        while (r < n) {
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // Shrink the window from the left if the number of distinct characters exceeds k
            while (map.size() > k) {
                char cl = s.charAt(l);
                map.put(cl, map.get(cl) - 1);
                if (map.get(cl) == 0) {
                    map.remove(cl);
                }
                l++;
            }

            // Count all substrings ending at `r` with at most `k` distinct characters
            ans += r - l + 1;

            r++;
        }

        return ans;
    }
}