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
                //Uncomment for Producer filling array
                //Thread.sleep(1200); 
                //Uncomment for Consistent Production and Consumption
                //Thread.sleep(300);

                //Uncomment for Consumer emptying array
                //Thread.sleep(1500);

                //option 2: produce to full then sleep
                // do {
                //     insert(insertion);
                // } while (arr.getCount() < arr.getBufferSize());
                // Thread.sleep(10000);
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
