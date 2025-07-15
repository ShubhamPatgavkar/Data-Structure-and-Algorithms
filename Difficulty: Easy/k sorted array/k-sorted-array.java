// User function Template for Java

class Solution {
    static String isKSortedArray(int arr[], int n, int k) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(arr[i],i);
        }
        Arrays.sort(arr);
        
        for(int i=0; i<n; i++){
            if(Math.abs(map.get(arr[i]) - i) > k){
                return "No";
            }    
        }
        
        return "Yes";
    }
}