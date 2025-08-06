class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer>set = new TreeSet<Integer>(Comparator.reverseOrder());

        for(int x : nums){
            set.add(x);
        }
        int i =0;
        if(set.size() < 3 && i < set.size()){
            for (Integer num : set) {
            if(i == set.size() ){
                return num;
            }
            i++;
        }

        }
         for (Integer num : set) {
            if(i == 2){
                return num;
            }
            i++;
        }

        return set.size() == 1 ? set.first() : -1;
    }
}