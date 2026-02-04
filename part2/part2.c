#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#define MAX 100

int main() {
    char input[MAX];
    char command[MAX], arg1[MAX], arg2[MAX];
    printf("DOS command interpreter\n");

    while (1) {
        printf("type command: ");
        fgets(input, MAX, stdin);

        command[0] = arg1[0] = arg2[0] = '\0';
        sscanf(input, "%s %s %s", command, arg1, arg2);

        if (strcmp(command, "cd") == 0) {
            if (strlen(arg1) == 0) {
                printf("error too few arguments\n");
            } else {
                chdir(arg1);
            }
        }

        else if (strcmp(command, "dir") == 0) {
            system("ls");
        }

        else if (strcmp(command, "type") == 0) {
          concat(arg1,arg2);
        }

        else if (strcmp(command, "del") == 0) {
           del(arg1); 
        }

        else if (strcmp(command, "ren") == 0) {
           
        }

        else if (strcmp(command, "copy") == 0) {
            
        }

        else {
            printf("unknown command\n");
        }
    }
    return 0;
}
