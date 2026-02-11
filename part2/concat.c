
#MAX_LINE 2048

char* concat(arg1, arg2){

  FILE *fptr1 = fopen(arg1, "r");

  char out[MAX_LINE];

  while(fgets(out, MAX_LINE, fptr1) != NULL){

    printf("%s\n", out);

  }

  FILE *fptr2 = fopen(arg2, "r");

  while(fgets(out, MAX_LINE, fptr1) != NULL){
    
  printf("%s\n", out);

  }


  return 0;
}


