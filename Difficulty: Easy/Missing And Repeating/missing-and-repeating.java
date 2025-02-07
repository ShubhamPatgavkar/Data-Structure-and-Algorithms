//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList; // Import ArrayList
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            // Get the result as an ArrayList<Integer>
            ArrayList<Integer> ans = new Solution().findTwoElement(arr);
            System.out.println(ans.get(0) + " " + ans.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java



class Solution {
    // Function to find two elements in the array: the repeating and the missing number
    ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;
        int hash[] = new int[n+1];
        
        for(int i =0 ; i<n ;i++){
            int j = arr[i];
            hash[j]++;
        }
        ArrayList<Integer>list = new ArrayList<>();
        int r =0;
        int m =0;
        for(int j=1; j<n+1; j++){
            if(hash[j] > 1){
                r = j;
            }
            if(hash[j] == 0){
                m =j;
            }
        }
        list.add(r);
        list.add(m);
        return list;
      
    }
}
