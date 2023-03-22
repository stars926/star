package learn.jdk8.completableFuture;

import java.util.concurrent.*;

public class ApplyToEitherDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        CompletableFuture future1 = CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("future1："+Thread.currentThread().getName());
            return "hello";
        },executorService);


        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(()-> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("future2："+Thread.currentThread().getName());
            return "itheima";
        },executorService);

        CompletableFuture future = future1.applyToEitherAsync(future2, (value) -> {
            System.out.println("result" + Thread.currentThread().getName());
            return value;
        }, executorService);

        System.out.println(future.get());

        executorService.shutdown();


    }
}
