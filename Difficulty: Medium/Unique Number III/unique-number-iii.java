//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSingle(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int getSingle(int[] arr) {
        HashMap<Integer,Integer>map = new HashMap<>();
        
        for(int c: arr){
            if(map.containsKey(c) && map.get(c) == 2){
                map.remove(c);
            }else{
                map.put(c, map.getOrDefault(c,0)+1);
            }
        }
        
        for(int x : map.keySet()){
        return x;
    }

        return 0;
        
    }
}