#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
    struct node* next;
    struct node* prev;
};

struct node* createNode(int data) {
    struct node* newnode = (struct node*)malloc(sizeof(struct node)); 
    newnode->next = NULL;
    newnode->prev = NULL;
    newnode->data = data;
    return newnode;
}

void insertAtend(struct node** head, int data) {
    struct node* newnode = createNode(data);
    if (*head == NULL) {
        *head = newnode;
    } else {
        struct node* temp = *head;
        while (temp->next != NULL){
            temp = temp->next;
        }
        temp->next = newnode;
        newnode->prev = temp;
    }
}   

void displayForward(struct node* head){
    struct node* temp = head;
    while(temp  != NULL){
        printf("the element is %d\n",temp->data);
     temp = temp->next;
        
    }
}

void displayBackward(struct node* head) {
    printf("Doubly Linked List (Backward): ");
    struct node* temp= head;

    // Move to the last node
    while (temp->next != NULL) {
        temp = temp->next;
    }

    // Traverse backward and print the elements
    while (temp!= NULL) {
        printf("%d <-> ", temp->data);
        temp = temp->prev;
    }
    printf("NULL\n");
}


int main() {
    struct node* head = NULL;
    insertAtend(&head, 1);
    insertAtend(&head, 2);
    insertAtend(&head, 3);
    
    displayForward(head);
 
    
    return 0;
}
