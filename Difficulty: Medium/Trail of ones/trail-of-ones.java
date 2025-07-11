class Solution {
    public int countConsec(int n) {
        // this is kind of fibonnaci
        if(n == 2){
            return 1;
        }
        
        int first = 1;
        int second = 1;
        int third = 1;
        int result = 0;
        
        for(int i =3; i <= n; i++){
            result = first * 2 + second;
            first = result;
            int temp = second;
            second = second + third;
            third = temp;
            
        }
        
        return result;
    }
}
