#include "header.h"

void concat(char* arg1,char* arg2){


  FILE *fptr1 = fopen(arg1, "r");

  char out[MAXLINE];

  if(fptr1 == NULL){

    char *msg = "Error when opening file one";
    printf("%s", msg);
    return;

  }

  while(fgets(out, MAXLINE, fptr1) != NULL){

    printf("%s", out);

  }

  fclose(fptr1);
  
  if(arg2[0] != '\0'){
    FILE *fptr2 = fopen(arg2, "r");

    if(fptr2 == NULL){

      char *msg = "Error when opening file two";
      printf("%s", msg);
      return;
    }

   while(fgets(out, MAXLINE, fptr1) != NULL){
    
      printf("%s", out);

    }

    fclose(fptr2);
  } 

  return;
}


