class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer>set = new TreeSet<Integer>(Comparator.reverseOrder());

        for(int x : nums){
            set.add(x);
        }
        int i =0;
        if(set.size() < 3 ){
            return set.first();
        }

        
         for (Integer num : set) {
            if(i == 2){
                return num;
            }
            i++;
        }

        return 0;
    }
}