class Solution {
    public int substrCount(String s, int k) {
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        int j =0;
        int c =0;
        
        for(int i=0; i<s.length(); i++){
            
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
            
            while(i - j + 1 > k && j < s.length()){
                map.put(s.charAt(j),map.get(s.charAt(j)) -1);
                
                if(map.get(s.charAt(j)) == 0){
                    map.remove(s.charAt(j));
                }
                j++;
            }
            if(map.size() == k - 1 && i- j + 1 == k){
                c++;
            }
        }
        
        return c;
        
    }
}