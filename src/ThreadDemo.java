import java.time.Duration;
import java.time.LocalTime;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {

        Thread[] threads = new Thread[100];
        LocalTime beforeStart = LocalTime.now();

        for (int i = 0; i < 100; i++) {
            final int fi = i;
            threads[i] = new Thread(() -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println(fi);
            });
            threads[i].start();
        }

        System.out.println("Hello in Main");

        for (int i = 0; i < 100; i++) {
            threads[i].join();
        }

        LocalTime timeAfter = LocalTime.now();
        System.out.println(Duration.between(beforeStart, timeAfter));
    }
}
