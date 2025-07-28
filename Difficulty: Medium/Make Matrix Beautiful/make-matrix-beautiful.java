class Solution {
    public static int balanceSums(int[][] mat) {
         // calculating by row sum 
         int maxi =0;
         ArrayList<Integer>list = new ArrayList<>();
         for(int i=0;i<mat.length; i++){
             int sum =0;
             for(int j=0; j<mat[0].length; j++){
                sum += mat[i][j];
             }
             list.add(sum);
             maxi = Math.max(maxi,sum);
         }
         
        for(int i=0; i<mat[0].length; i++){
            int sum =0;
            for(int j=0; j<mat.length; j++){
                sum += mat[j][i];
            }
            maxi = Math.max(maxi,sum);
        }
         int ops =0;
         for(int s : list){
             if(s != maxi){
                 ops += maxi - s;
             }
         }
         
         return ops;
    }
}