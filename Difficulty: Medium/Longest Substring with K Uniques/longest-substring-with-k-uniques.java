class Solution {
    public int longestKSubstr(String s, int k) {
        
        HashMap<Character,Integer>map = new HashMap<>();
        int j = 0;
        int ans =-1;
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
            
            while(map.size() > k && j < s.length()){
                map.put(s.charAt(j), map.get(s.charAt(j))-1);
                if(map.get(s.charAt(j)) == 0){
                    map.remove(s.charAt(j));
                }
                j++;
            }
            if(map.size() == k){
                ans = Math.max(ans,i-j+1);
            }
        }
    
        return ans;    
    }
}