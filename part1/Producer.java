public class Producer implements Runnable {
    private BoundedBuffer arr;

    public Producer(BoundedBuffer arr) {
        this.arr = arr;
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

                //option 2: produce to full then sleep
                /*do {
                    insert(insertion);
                } while (arr.getCount() < arr.getBufferSize());
                Thread.sleep(10000);*/
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
