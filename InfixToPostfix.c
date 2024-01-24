#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct stack{
    int size;
    int top;
    char *arr;
}; 

int isEmpty(struct stack *ptr){
    if (ptr->top == -1){
        return 1;
    }else{
        return 0; 
    }
}

int isFull(struct stack *ptr){
    if (ptr->top == (ptr->size-1)){
        return 1;
    }else{
        return 0;
    }
}

void push(struct stack *s1,char value){
    if(isFull(s1)){
        printf("print stack is full\n");
        exit(1);
    }else{
        s1->top++;
        s1->arr[s1->top] = value;
    }
}
char pop(struct stack* s1) {
    if (isEmpty(s1)) {
        printf("stack is empty\n");
        exit(1);
    } else {
        char value = s1->arr[s1->top];
        s1->top--;
        return value;
    }
}

int precedence(char ch){
    if (ch == '*' || ch == '/'){
        return 3;
    }else if(ch == '+' || ch =='-'){
        return 2;
    }else{
        return 0;
    }
}

int operator(char ch) {
    return (ch == '+' || ch == '-' || ch == '*' || ch == '/');
}

      

int stacktop(struct stack*ps){
    return ps->arr[ps->top];
}

char * InfixToPostfix(char* infix){
    struct stack* ps = (struct stack*)malloc(sizeof(struct stack));
    ps->top = -1;
    ps->size = 50;
    ps->arr = (char*)malloc(ps->size*sizeof(char));

    char * postfix = (char*)malloc(strlen(infix)+1*sizeof(char));
    int i = 0;
    int j = 0;

    while(infix[i]!='\0'){
        if (!operator(infix[i])){
            postfix[j]= infix[i];
            j++;
            i++;
        }
        else{
                if(precedence(infix[i])>precedence(stacktop(ps))){
                    push(ps,infix[i]);
                    i++;
                }else{
                    postfix[j]=pop(ps);
                    j++;
                }

        }


    }while(!isEmpty(ps)){
        postfix[j]=pop(ps);
        j++;
    }postfix[j]='\0';

    return postfix;
}



int main(){
char infix [] = "ABC+-CDB/+*C+";
printf("convertion of this equation from prifix to postfix is %s\n",InfixToPostfix(infix));
return 0;
}