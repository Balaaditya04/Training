import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPractice {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService exec = Executors.newSingleThreadExecutor();
//        int n = 5;
//
//        Callable<Long> factorialCallable = new Callable<Long>() {
//            @Override
//            public Long call() throws Exception {
//                Long ans = 1L;
//                for(int i = 1; i<=n; i++) ans*=(i*1L);
//                return ans;
//            }
//        };
//        Future<Long> status = exec.submit(factorialCallable);
//        Long result = status.get();
//        System.out.println(result);
//        exec.shutdown();

        // adding array elements using threads
        int [] arr = {1,2,3,4,5,6,7,8,9,10};
        ExecutorService exec = Executors.newFixedThreadPool(10);
        List<Callable<Integer>> arrCallables = new ArrayList<>();
        List<Future<Integer>> arrFutures = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i<10; i++){
            final int fi = i;
            Callable<Integer> elementAdder = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
//                    sum[0] += arr[fi];
                    return arr[fi];
                }
            };
            arrCallables.add(elementAdder);
        }
        arrFutures = exec.invokeAll(arrCallables);
        for(int i = 0; i<10; i++){
            sum += arrFutures.get(i).get();
        }
        exec.shutdown();
        System.out.println(sum);
    }
}