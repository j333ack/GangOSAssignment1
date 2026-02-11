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
                        Thread.sleep(400);

                }
                //consumer starts asleep to ensure producer can put stuff in array before they start to consume

                //consume an item from the buffer

                //option 1: normal
               // takeOut = takeOut();

                //option 2: eat all then sleep
            //     do {
            //         takeOut = takeOut();
            //     } while (arr.getCount() > 0);
            //     //Uncomment for consisitent Production and Consumption
            //    //Thread.sleep(1200);
            //    //Uncomment for Producer filling array
            //     Thread.sleep(300);

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
