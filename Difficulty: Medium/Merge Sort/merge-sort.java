class Solution {
    void merge(int arr[], int lt, int r, int mid){
        ArrayList<Integer> list = new ArrayList<>();
        int l = lt;
        int i = mid + 1;
        
        while(l <= mid && i <= r){
            if(arr[l] <= arr[i]){
                list.add(arr[l++]);
            } else {
                list.add(arr[i++]);
            }
        }
        
        while(l <= mid){
            list.add(arr[l++]);
        }
        
        while(i <= r){
            list.add(arr[i++]);
        }
        
        for (int j = 0; j < list.size(); j++) {
            arr[lt + j] = list.get(j);
        }
    }

    void mergeSort(int arr[], int l, int r) {
        if(l >= r){
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, r, mid);
    }
}
