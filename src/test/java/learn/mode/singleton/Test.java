package learn.mode.singleton;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    private static ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        // Singleton instance = Singleton.getInstance();
        // System.out.println(instance);
        // Singleton y = Singleton.getInstance();
        // System.out.println(y);

        CompletableFuture<Singleton> task1 = CompletableFuture.supplyAsync(() -> {
            // 执行异步任务1
            return Singleton.getInstance3();
        }, executor);
        CompletableFuture<Singleton> task2 = CompletableFuture.supplyAsync(() -> {
            // 执行异步任务2
            return Singleton.getInstance3();
        }, executor);
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(task1, task2);
        allTasks.thenRun(() -> {
            // 所有任务执行完成后的回调函数
            System.out.println(task1.join()); // 输出异步任务1的结果
            System.out.println(task2.join()); // 输出异步任务2的结果
        });


    }
}
