public class Consumer implements Runnable {
    private BoundedBuffer arr;
    private final Case current;
    public Consumer(BoundedBuffer arr, Case current) {
        this.arr = arr;
        this.current = current;
    }

    @Override
    public void run(){
        int takeOut;

        try {
            while (true) {
                takeOut = takeOut();
                switch (current){
                    case bufferFull:
                        Thread.sleep(1500);
                        break;
                    case bufferEmpty:
                        Thread.sleep(100);
                        break;
                    case inbetween:
                        Thread.sleep(410);

                }
            }
        } catch (InterruptedException e) {
            System.out.println("Consumer thread interrupted");
        }
    }

    public int takeOut() throws InterruptedException {
        int takeOut = arr.remove();
        if (takeOut != 0) {
            System.out.println("Consumer consumed " + takeOut);
        }
        return takeOut;
    }

}

