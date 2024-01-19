#include <stdio.h>
#include <stdlib.h>

struct node{
    int data;
    struct node *next;
};

// function to create a node
struct node* create_ll(int data){
    struct node* newnode = (struct node*)malloc(sizeof(struct node));
    newnode->data = data;
    newnode->next = NULL;
    return newnode;
}

//function for insert at beggining
struct node* insertatstart(struct node *head, int data){
    struct node* newnode = create_ll(data);
    newnode->next = head;
    return newnode;
}

// function to insert at end 
struct node* insertatend(struct node* head, int data){
    struct node* node = (struct node*)malloc(sizeof(struct node));
    
    struct node* temp = head;
    while (temp->next!= NULL){
        temp = temp->next;
    }
    temp->next = node;
    node->next = NULL;
    node->data = data;
    return head ;
}

// function to insert in between
struct node* insertinbetween(struct node *head, int data, int index){
    struct node *ptr = (struct node*)malloc(sizeof(struct node));
    struct node *p = head; 
    int i=0; 

    while(i<(index-1)){
        p = p->next;
        i++;
    }
    ptr->next = p->next;
    p->next = ptr;
    ptr->data = data;
    return head;
}

void printlist(struct node* head){
    struct node* temp;
    temp = head;
    int i =0;
     while(temp!=NULL){
        printf("the %d index element is %d\n",i,temp->data);
        temp = temp->next;
        i++;
     }

}

void reversePrint(struct node *head)
{
    if (head == NULL)
    {
        return;
    }
    reversePrint(head->next);
    printf("%d\n", head->data);
}

   
int main (){

    struct node * head = NULL;

    head = insertatstart(head,6);
    head = insertatstart(head,5);
    head = insertatstart(head,4);
    head = insertatstart(head,3);
    head = insertatstart(head,2);
    head = insertatstart(head,1);

  

    // printf("list before insertion\n");
    // printlist(head);

    // printf("\n");
    // printf("After insertion in between\n");

    insertinbetween(head,55,3); // inserted 55 at index 3rd..
    // printlist(head);

    // printf("\n");
    // printf("After insertion at end \n");

//    head = insertatend(head,2);
//    head = insertatend(head,1);
       printlist(head);
    //reversePrint(head);

return 0;
}