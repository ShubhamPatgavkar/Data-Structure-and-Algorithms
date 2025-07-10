class Solution {
    // Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high) {
        if(low < high){
            int part = partition(arr,low,high);
            quickSort(arr, low, part-1);
            quickSort(arr,part+1,high);
        }
        
    }

    static int partition(int arr[], int low, int high) {
        int pivot = arr[low];
        int i = low + 1;
        int j = high;

        while (true) {
            // Move i to the right as long as arr[i] <= pivot
            while (i <= high && arr[i] <= pivot) {
                i++;
            }
            // Move j to the left as long as arr[j] > pivot
            while (j >= low + 1 && arr[j] > pivot) {
                j--;
            }
            if (i >= j) {
                break;
            }

            // Swap arr[i] and arr[j]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        // Swap pivot with arr[j]
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
        
        
    }
}