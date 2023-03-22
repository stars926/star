package learn.jdk8.completableFuture;

import java.util.concurrent.*;

public class ThenApplyDemo {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {

            //子任务
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return 123;
        }, executorService).thenApplyAsync(value->{
            System.out.println(Thread.currentThread().getName());
            int result = value*10;
            System.out.println(result);
            return result;
        },executorService);

        //主任务
        System.out.println("main end ");

        //获取子任务结果
        try {
            Integer value = future.get();
            System.out.println(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();

    }
}
