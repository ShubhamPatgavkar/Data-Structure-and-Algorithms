class Solution {
    public boolean isPalinSent(String s) {
        // code here
        s = s.toLowerCase();
        int i =0;
        int j = s.length()-1;
        
        while(i < j ){
            while(s.charAt(i) == ' ' || !Character.isLetterOrDigit(s.charAt(i)) && i < j){
                i++;
            }
            while(s.charAt(j) == ' ' || !Character.isLetterOrDigit(s.charAt(j)) && i < j){
                j--;
            }
            if(s.charAt(i) != s.charAt(j)){
                return false; 
            }
            
            i++;
            j--;
        }
        
        return true;
        
    }
}