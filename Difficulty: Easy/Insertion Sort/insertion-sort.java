class Solution {
    // Please change the array in-place
    public void insertionSort(int arr[]) {
        // start with 1st index then shift the left unsorted portion
        
        for(int i=1; i<arr.length; i++){
            int j = i -1;
            int key = arr[i]; // store the min element 
            
            while(j >=0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
}