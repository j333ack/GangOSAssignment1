CFLAGS=-Wall    -g

clean:
	rm    -f    part2

part2: part2.o concat.o
	gcc -o part2 part2.o concat.o

part2.o: part2.c header.h
	gcc -c part2.c

concat.o: concat.c header.h
	gcc -c concat.c

