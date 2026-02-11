public class Producer implements Runnable {
    private BoundedBuffer arr;
    private final Case current;

    public Producer(BoundedBuffer arr,Case current) {
        this.arr = arr;
        this.current = current;
    }

    @Override
    public void run() {
        int insertion = 0;
        try {
            while (true){
                //produce an item and enter it into the buffer

                insertion++;

                //option 1: normal
                insert(insertion);
                
                switch(current){
                    case bufferFull:
                    Thread.sleep(100);
                    break;
                    case bufferEmpty:
                        Thread.sleep(1500);
                        break;
                    case inbetween:
                        Thread.sleep(400);
                        break;
                    default:
                        break;

                }
            }
        } catch (InterruptedException e) {
            System.out.println("Producer interrupted");
        }
    }

    public void insert(int insertion) throws InterruptedException {
        arr.insert(insertion);
        System.out.println("Producer produced " + insertion);
    }

}

