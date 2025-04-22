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
            int ans = ob.findUnique(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int findUnique(int[] arr) {
        // code here
        HashSet<Integer>set = new HashSet<>();
        
        for(int x : arr){
            if(set.contains(x)){
                set.remove(x);
            }else{
                set.add(x);
            }    
        }
    
        Integer onlyElement = set.toArray(new Integer[0])[0];
        return onlyElement;
    }
}