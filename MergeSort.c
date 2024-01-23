#include <stdio.h>

void merge(int l, int h, int mid , int arr[]){
    int i = l;
    int j = mid+1;
    int k = l;
    int A[100];
    
    while(i<= mid && j<=h){
        if(arr[i]<arr[j]){
            A[k]= arr[i];
            i++;
            k++;
        }

        else{
            A[k] = arr[j];
            j++;
            k++;
        }
    }
    while(i<=mid){
        A[k]= arr[i];
        i++;
        k++;
    }

    while(j<=h){
        A[k]= arr[j];
        j++;
        k++;
    }

    for(int i = 0; i <= h; i++){
        arr[i] = A[i];
    }

}

void mergeSort(int arr[], int l, int h)
{
    if (l < h)
    {
        int mid = (l + h) / 2;
        mergeSort(arr, l, mid);     // sort the left side
        mergeSort(arr, mid + 1, h); // sort the right side
        merge(l, h, mid, arr);
    }
}

void printArray(int *A, int size)
{
    for (int i = 0; i < size; i++)
    {
        printf("%d ", A[i]);
    }
    printf("\n");
}


int main(){
    int arr[] ={2,6,9,4,5,6,4};
    mergeSort(arr,0,6);
    printArray(arr, 7);
        return 0;
 }

