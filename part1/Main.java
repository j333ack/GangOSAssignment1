//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        final int BUFFER_SIZE = 5;
        int empty = 0;
        int full = 0;
        //create array of integers, set to empty
        //int[] intArr = new int[BUFFER_SIZE]; //all set to 0
        BoundedBuffer buffer = new BoundedBuffer();

        //create producer and consumer threads
        //each thread a reference to the intArr object
        Thread producer = new Thread(new Producer(buffer), "Luigi");
        Thread consumer = new Thread(new Consumer(buffer), "Mario");

        //Thread producer = new Thread(new Producer(intArr));
        //Thread consumer = new Thread(new Consumer(intArr));

        System.out.println();
        //start threads
        producer.start();
        consumer.start();

    }
}