#include "header.h"

void del(char* arg1,char* arg2){

  if(arg1[0] == '\0'){

    char* msg = "Must specify at least one file to remove";
    printf("%s\n", msg);

    return;

  }

  if(remove(arg1) != 0){

    char* msg = "error deleting file 1";
    printf("%s\n", msg);

  }

  if(arg2[0] != '\0'){

    if(remove(arg2) != 0){

      char* msg = "error deleting file 2";
      printf("%s\n", msg);

      return;

    }
  }

  return;

}
