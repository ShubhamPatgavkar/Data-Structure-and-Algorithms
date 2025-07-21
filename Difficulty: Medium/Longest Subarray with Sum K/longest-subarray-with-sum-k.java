// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // algo first add zero with index -1
        // put curr sum with index in the map
        // search for the cur - k in the map and calculate max length if present 
       
        int sum =0;
        int maxlen = 0;
        HashMap<Integer,Integer>map = new HashMap<>();
        map.put(0,-1); 
        for(int i=0; i<arr.length; i++){
            sum+= arr[i];
            if(map.containsKey(sum-k)){
                maxlen = Math.max(maxlen,i- map.get(sum-k));
            }
            
            if (!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        
        return maxlen;
        
    }
}
