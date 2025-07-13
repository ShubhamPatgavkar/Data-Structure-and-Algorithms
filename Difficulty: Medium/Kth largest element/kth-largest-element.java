class Solution {
    // Function to return kth largest element from an array.
    public static int KthLargest(int arr[], int k) {
        
    PriorityQueue<Integer> pq = new PriorityQueue<>(); // min heap 
    
    for(int i=0;i<k; i++){
        pq.add(arr[i]);
    }
    
    for(int j= k; j< arr.length; j++){
        if(!pq.isEmpty() && pq.peek() < arr[j]){
            pq.poll();
            pq.add(arr[j]);
        }
        
    }
    
    return pq.poll();
        
    }
}