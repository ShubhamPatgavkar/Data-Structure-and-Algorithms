#include <stdio.h>
#include <stdlib.h>
#include <string.h>


void main (){

    FILE *ptr ;
    int x = 123;
    char ch = 's';
    char str [50];

    ptr = fopen("abc.txt","w");
    printf("enter the string\n");
    gets(str);
 
    fprintf(ptr,"%d %s %c",x,str,ch);

    //fputs(str,ptr); 
    //         or
    //for (int i=0;i<strlen(str);i++){
    //   fputc(str[i],ptr);
    //}

    fclose(ptr);


}