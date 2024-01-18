#include <stdio.h>
#include <stdlib.h>

int  main(){

struct node{
    int data;
    struct node*  next;
};

    struct node* n1 = (struct node*)malloc(sizeof(struct node));
    struct node* n2 = (struct node*)malloc(sizeof(struct node));
    struct node* n3 = (struct node*)malloc(sizeof(struct node));
    struct node* n4 = (struct node*)malloc(sizeof(struct node));
    
    n1->data =4;
    n1->next =n2;
    n2->data =3;
    n2->next =n3;
    n3->data =2;
    n3->next =n4;
    n4->data =1;
    n4->next =NULL;

    struct node *head;
    struct node* temp;
    
    head = n1;
    temp =head;

    while (temp!=NULL){
        printf("%d",temp->data);
        temp = temp->next;
    }
    free(n1);
    free(n2);
    free(n3);
    free(n4);

return 0; 
}