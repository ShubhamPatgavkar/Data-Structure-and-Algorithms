#include  <stdio.h>
#include  <stdlib.h>

struct CircularQueue{
    int size;
    int f;
    int r;
    int *arr;
};


void Enqueue(struct CircularQueue* Q1,int data){
    if((Q1->r + 1) % Q1->size == Q1->f){
        printf("circular Queue is full\n");
        exit(1);
    }else{
        Q1->r = (Q1->r+1)% Q1->size;
        Q1->arr[Q1->r] =  data;
    }
}

int Dequeue(struct CircularQueue* Q1){
    int a = -1;
    if(Q1->f == Q1->r){
        printf("queue is empty\n");
        exit(1);
    }else{
        Q1->f = (Q1->f + 1) % Q1->size;
        a = Q1->arr[Q1->f];
        return a;
    }
} 

int main(){
    struct CircularQueue *Q;
    Q->size = 6;
    Q->f = 0;
    Q->r = 0;
    Q->arr = (int *)malloc(Q->size*sizeof(int));

    Enqueue(Q,1); 
    Enqueue(Q,4);
    Enqueue(Q,7);
    Enqueue(Q,8);
    Enqueue(Q,9);


    // if the size of the queue is 4 then only 3 element can be filled in a circular queue because 1 space remain empty 

    printf(" the dequeued element is %d\n",Dequeue(Q));
    printf(" the dequeued element is %d\n",Dequeue(Q));
    printf(" the dequeued element is %d\n",Dequeue(Q));
    
    // //  after dequeuing the element we can again use the space to enqueue the elements
    // Enqueue(Q,5);
    // Enqueue(Q,11);
    // Enqueue(Q,3);

    // printf(" the dequeued element is %d\n",Dequeue(Q));
    // printf(" the dequeued element is %d\n",Dequeue(Q));
    // printf(" the dequeued element is %d\n",Dequeue(Q));
    // printf(" the dequeued element is %d\n",Dequeue(Q));

    return 0;

}
