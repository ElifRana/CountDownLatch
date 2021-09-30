import java.util.concurrent.CountDownLatch;

public class Processor implements Runnable{

    private CountDownLatch latch;

    public Processor(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Thread başladı.");

        try{
            Thread.sleep(5000);
        }catch (InterruptedException e) {
        }
        latch.countDown();
    }
}
