//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends



 class Pair implements Comparable<Pair> {
    int d;
    int p;

    public Pair(int pro, int d) {
        this.d = d;
        this.p = pro;
    }

    @Override
    public int compareTo(Pair other) {
        return Integer.compare(other.p, this.p); // Descending order
    }
}
    
class Solution {
   
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        
        int sc[] = new int[profit.length+1];
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(int i=0; i<deadline.length; i++){
            pq.add(new Pair(profit[i], deadline[i]));
        } 
        int c = 0;
        int totalp =0;
        
        while(!pq.isEmpty()){
            Pair p1 = pq.poll();
            for(int i = p1.d; i>  0; i--){
                if(sc[i] == 0){
                    sc[i] = p1.p;
                    totalp += p1.p;
                    c++;
                    break;
                }
            }
        }
        
        ArrayList<Integer>list = new ArrayList<>();
        list.add(c);
        list.add(totalp);
        return list;
        
    }
}
    



//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());

        while (t-- > 0) {
            String[] deadlineInput = sc.nextLine().trim().split("\\s+");
            int[] deadline =
                Arrays.stream(deadlineInput).mapToInt(Integer::parseInt).toArray();

            String[] profitInput = sc.nextLine().trim().split("\\s+");
            int[] profit =
                Arrays.stream(profitInput).mapToInt(Integer::parseInt).toArray();
            Solution obj = new Solution();
            ArrayList<Integer> result = obj.jobSequencing(deadline, profit);
            System.out.println(result.get(0) + " " + result.get(1));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends