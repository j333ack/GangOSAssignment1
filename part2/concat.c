
void concat(arg1, arg2){

  FILE *fptr1 = fopen(arg1, "r");

  if(fptr1 == NULL){

    printf("File is not able to be opened");

  }

  char *outstr;

  while(fgets(outstr, 2048, fptr1) != EOF){

    printf("%s", outstr);

  }

  FILE *fptr2 = fopen(arg2, "r");

  while(fgets(outstr, 2048, fptr1) != EOF){

    printf("%s", outstr);

  }

  return 0;
  

}
