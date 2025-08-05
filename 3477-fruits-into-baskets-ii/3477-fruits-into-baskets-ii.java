class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int count = fruits.length;
        boolean vis[] = new boolean[fruits.length];

        for(int i=0; i< fruits.length; i++){
            for(int j=0; j<fruits.length; j++){
               if(fruits[i] <= baskets[j] && !vis[j]){
                    vis[j] = true;
                    count--;
                    break;
               }
            }
        }
            return count;
    }
}