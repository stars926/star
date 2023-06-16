package learn.thre;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiTask {

    private static ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(() -> {
            // 执行异步任务1
            return "result1";
        }, executor);
        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(() -> {
            // 执行异步任务2
            return "result2";
        }, executor);
        CompletableFuture<String> task3 = CompletableFuture.supplyAsync(() -> {
            // 执行异步任务3
            return "result3";
        }, executor);
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(task1, task2, task3);
        allTasks.thenRun(() -> {
            // 所有任务执行完成后的回调函数
            System.out.println(task1.join()); // 输出异步任务1的结果
            System.out.println(task2.join()); // 输出异步任务2的结果
            System.out.println(task3.join()); // 输出异步任务3的结果
        });
        CompletableFuture<String> task11 = CompletableFuture.supplyAsync(() -> {
            // 执行任务1
            return "result1";
        });

        CompletableFuture<String> task22 = task11.thenCompose(result1 -> CompletableFuture.supplyAsync(() -> {
            // 执行任务2，使用 task1 的结果 result1
            return result1 + "result2";
        }));

        allTasks.thenRun(() -> {
            // 所有任务执行完成后的回调函数
            System.out.println(task11.join()); // 输出异步任务1的结果
            System.out.println(task22.join()); // 输出异步任务2的结果
        });
    }
}
