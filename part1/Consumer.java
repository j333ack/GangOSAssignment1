public class Consumer implements Runnable {
    private BoundedBuffer arr;

    public Consumer(BoundedBuffer arr) {
        this.arr = arr;
    }

    @Override
    public void run(){
        int takeOut;

        try {
            while (true) {

                //consumer starts asleep to ensure producer can put stuff in array before they start to consume

                //consume an item from the buffer

                //option 1: normal
                //takeOut = takeOut();

                //option 2: eat all then sleep
                do {
                    takeOut = takeOut();
                } while (arr.getCount() > 0);
                Thread.sleep(10000);

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
