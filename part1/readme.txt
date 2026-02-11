Programming Project #1 Part 1
Contributors: Josh, Steven, Mike

Java program to simulate the use of producer and consumer threads. The program simulates the following cases:
    1. The buffer is full and the Producer is waiting
    2. The buffer is empty and the Consumer is waiting 
    3. The Producer and Consumer are producing and consuming at similar rates

The different test cases are controlled via uncommenting lines in main, and setting the current case to whatever line is uncommented:
    Case current = Case.bufferFull;
    Case current = Case.bufferEmpty;
    Case current = Case.inbetween;
