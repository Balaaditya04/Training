class ThreadOne implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread One: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(e);
            }
        }
    }
}

public class threads {

    public static void main(String[] args) {

        ThreadOne t1 = new ThreadOne();
        Thread thread1 = new Thread(t1);
        thread1.start();

        for (int i = 1; i <= 100; i++) {
            System.out.println("Main Thread: " + i);
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(e);
            }
        }
    }
}
