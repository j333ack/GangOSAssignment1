CFLAGS=-Wall    -g

clean:
	rm    -f    part2

part2: part2.o concat.o del.o
	gcc -o part2 part2.o concat.o del.o

part2.o: part2.c header.h
	gcc -c part2.c

concat.o: concat.c header.h
	gcc -c concat.c

del.o: del.c header.h
	gcc -c del.c

