public class BoundedBuffer {
    private static final int BUFFER_SIZE = 5;
    private int count;  //no. of items in buffer
    private int in;     //points to next free position
    private int out;    //points to next full position
    private int[] buffer;

    public BoundedBuffer() {
        //buffer initially empty
        count = 0;
        in = 0;
        out = 0;
        buffer = new int[BUFFER_SIZE];
    }

    //producers call this method
    public synchronized void insert(int item) throws InterruptedException {
        while (count == BUFFER_SIZE) {
            System.out.println("Buffer is full, producer cannot produce until empty space available");
            wait(); //do nothing -- no free buffers
        }//end while

        //add item to the buffer
        ++count;
        buffer[in] = item;
        in = (in + 1) % BUFFER_SIZE;

        //notify there's data available
        notifyAll();
    }

    //consumers call this method
    public synchronized int remove() throws InterruptedException {
        int item;
        while (count == 0) {
            System.out.println("Consumer waiting, array is empty");
            wait(); //do nothing -- nothing to consume
        }

        //remove item from buffer
        --count;
        item = buffer[out];
        out = (out + 1) % BUFFER_SIZE;

        notifyAll();
        return item;
    }

    public synchronized int getCount() {
        return count;
    }
    public synchronized int getBufferSize() {
        return BUFFER_SIZE;
    }
}
