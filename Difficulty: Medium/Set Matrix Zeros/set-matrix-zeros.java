class Solution {
    class Pair{
        int i;
        int j;
        Pair(int i, int j ){
            this.i = i;
            this.j = j;
        }
    } 
    
    public void setZero(int[][] mat, int r, int c){
        // row
        for(int i=0;i<mat.length; i++){
            mat[i][c] = 0;
        }
        
        // col
        for(int j=0; j<mat[0].length; j++){
            mat[r][j] = 0;
        }
    }
    public void setMatrixZeroes(int[][] mat) {
        ArrayList<Pair>list = new ArrayList<>();
        for(int i=0; i<mat.length; i++){
            for(int j=0; j <mat[0].length; j++){
                if(mat[i][j] == 0){
                    list.add(new Pair(i,j));
                }
            }
        }
        
        for(int i=0; i<list.size(); i++){
            Pair p = list.get(i);
            setZero(mat,p.i,p.j);
        }
    }
}