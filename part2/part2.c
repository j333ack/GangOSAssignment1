#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <errno.h>
#include <fcntl.h>
#define MAX 100

int main() {
	char input[MAX];
	char command[MAX], arg1[MAX], arg2[MAX];
	printf("DOS command interpreter\n");
	printf("Type Ctrl-C to exit\n");

	while (1) {
        	printf("Type command: ");
        	fgets(input, MAX, stdin);

        	command[0] = arg1[0] = arg2[0] = '\0';
        	sscanf(input, "%s %s %s", command, arg1, arg2);

		if (strcmp(command, "cd") == 0) {
            	if (strlen(arg1) == 0) {
                	printf("Error: too few arguments\n");
            	} else {
                	chdir(arg1);
            	}
        	}

       else if (strcmp(command, "dir") == 0) {
    		DIR *d;
    		struct dirent *entry;

    		d = opendir(".");
    		if (d == NULL) {
        		perror("opendir");
        		continue;
    		}

    		while ((entry = readdir(d)) != NULL) {
        		printf("%s\n", entry->d_name);
    		}

    		closedir(d);
		}
//        else if (strcmp(command, "type") == 0) {
//          concat(arg1,arg2);
//        }

//        else if (strcmp(command, "del") == 0) {
//           del(arg1); 
//        }
	else if (strcmp(command, "ren") == 0) {
           if (rename(arg1, arg2) == 0)
                printf("File renamed\n");
            else
            {
                perror("File rename failure\n");
                exit(EXIT_FAILURE);
            }
        }
        else if (strcmp(command, "copy") == 0) {
//		printf("Working on it broski\n");
		char buffer[1024];
		int files[2];
		ssize_t count;

		files[0] = open(arg1, O_RDONLY);
		if (files[0] == -1)
			return -1;
		files[1] = open(arg2, O_WRONLY | O_CREAT, S_IRUSR | S_IWUSR);
		if (files[1] == -1)
		{
			close(files[0]);
			return -1;
		}

		while ((count = read(files[0], buffer, sizeof(buffer))) != 0)
			write(files[1], buffer, count);
        }
        else {
            printf("Unknown command\n");
        }
    }
    return 0;
}
