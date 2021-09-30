import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        //n sayıda threadın işlerini bitirdiklerini bildirene kadar ana thread bekletilir.
        //countDownLatch bizi senkronizasyon kolaylığı sağlar
        //countDownLatch yeniden kullanılabilir degildir.
        CountDownLatch latch = new CountDownLatch(3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            //submit asenkron görevlerin tamamlanıp tamamlanmadığını, iptal mi edildiklerini kontrol eder.
            executorService.submit(new Thread(new Processor(latch)));
        }

        try {
            latch.await();
        }catch (InterruptedException e){
        }
        System.out.println("Program bitti.");
    }
}
