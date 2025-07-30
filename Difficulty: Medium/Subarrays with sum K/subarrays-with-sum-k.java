class Solution {
    public int cntSubarrays(int[] arr, int k) {
        HashMap<Integer,Integer>map = new HashMap<>();
        int sum =0;
        int ans =0;
        map.put(0,1);
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            
            if(map.containsKey(sum - k)){
                ans += map.get(sum - k);
            }
            
            map.put(sum , map.getOrDefault(sum,0) + 1);
        }
        
        return ans;
        
    }
}