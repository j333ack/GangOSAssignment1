#include "header.h"

void concat(char* arg1,char* arg2){

  if(arg1[0] == '\0' || arg2[0] == '\0'){
    char *msg = "type requires two arguments";
    printf("%s" ,msg);
    return;

  }

  FILE *fptr1 = fopen(arg1, "r");

  char out[MAXLINE];

  while(fgets(out, MAXLINE, fptr1) != NULL){

    printf("%s", out);

  }

  fclose(fptr1);

  FILE *fptr2 = fopen(arg2, "r");

  while(fgets(out, MAXLINE, fptr1) != NULL){
    
  printf("%s", out);

  }

  fclose(fptr2);


  return;
}


