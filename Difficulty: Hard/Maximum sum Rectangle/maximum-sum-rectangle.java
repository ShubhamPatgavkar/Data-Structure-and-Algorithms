class Solution {
    public int maxRectSum(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        
        int ans = Integer.MIN_VALUE;
       
        
        for(int row =0;row < n; row++){
            // fixing the row 
            int temp[] = new int[m];
       
            for(int i= row; i< n; i++){
                
                for(int j=0; j<m; j++){
                        temp[j] += mat[i][j];
                }
                int sum = 0;
                for(int j=0; j<m; j++){
                
                    sum += temp[j];
                    
                    if(sum < temp[j]){
                        sum = temp[j];
                    }
                    ans = Math.max(ans, sum);
                }
            }
        }
    
        return ans;
    }
};