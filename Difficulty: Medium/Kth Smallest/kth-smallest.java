// User function Template for Java

class Solution {
    public static int kthSmallest(int[] arr, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    
    for(int i=0;i<k; i++){
        pq.add(arr[i]);
    }
    
    for(int j= k; j< arr.length; j++){
        if(!pq.isEmpty() && pq.peek() > arr[j]){
            pq.poll();
            pq.add(arr[j]);
        }
        
    }
    
    return pq.poll();
        
        
    }
}
