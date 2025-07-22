class Solution {
    public int missingNumber(int[] arr) {
        // code here
        int n =1;
        HashSet<Integer>set = new HashSet<>();
        for(int x : arr){
            set.add(x);
        }
        while(n <= 100){
            if(!set.contains(n)){
                return n;
            }
            n++;
        }
    
        return 0;
    }
}
