import java.util.concurrent.*;

public class CallableDemo {

    public static void main(String[] args)
            throws ExecutionException, InterruptedException {

        ExecutorService exec = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            final int fi = i;

            Runnable task = () -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println(fi);
            };

            Future<String> status = exec.submit(task, "Success");

            System.out.println(status.isDone());
            System.out.println(status.isCancelled());
        }

        exec.shutdown(); // MUST call first
        boolean terminated =
                exec.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("Executor terminated: " + terminated);
    }
}
