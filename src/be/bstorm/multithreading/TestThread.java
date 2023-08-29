package be.bstorm.multithreading;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class TestThread {

    private static final Random random = new Random();

    public static void main(String[] args) {
//        testThread();
//        testFutureTask();
        testCompletableFutur();
//        testSynchronousQueue();
    }

    private static void testThread() {

        Thread thread1 = new Thread(new MaTache());
        thread1.start();

        while (!thread1.getState().equals(Thread.State.TERMINATED)) {
            System.out.println("THREAD-1::Encours");
        }

        Thread thread2 = new Thread(() -> {

            int i = random.nextInt(10);
            System.out.println("Factoriel de " + i + " : " + IntStream.rangeClosed(1, i).reduce((a, b) -> a * b));
        });
        thread2.start();

        while (!thread2.getState().equals(Thread.State.TERMINATED)) {
            System.out.println("THREAD-2::Encours");
        }
    }

    private static void testFutureTask() {

        ExecutorService threadpool = Executors.newCachedThreadPool();
        Future<?> futureTask = threadpool.submit(() -> {
            int i = random.nextInt(10);
            System.out.println("Factoriel de " + i + " : " + IntStream.rangeClosed(1, i).reduce((a, b) -> a * b));
        });
        while (!futureTask.isDone()) {
            System.out.println("Calcul en cours...");
        }
        threadpool.shutdown();
    }

    private static void testCompletableFutur() {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> IntStream.rangeClosed(1, 5).reduce((a,b) -> a * b).getAsInt());
        completableFuture.completeOnTimeout(10, 100, TimeUnit.MILLISECONDS);
        while (!completableFuture.isDone()) {
        System.out.println("COMPLETABLEFUTUR::RUNNING");
        }
        try {

            System.out.println("Factoriel de 5 : " + completableFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private static void testSynchronousQueue() {

        var queue = new SynchronousQueue<String>();

        new Thread(() -> {
            try {
                Thread.sleep(Duration.ofSeconds(3));
                queue.put("Hello");

            } catch (InterruptedException ignored) {

            }
        }).start();

        try {
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        queue.clear();



    }
}

class MaTache implements Runnable {

    @Override
    public void run() {
        System.out.println("MaTache::run");
    }
}
class Factoriel implements Callable<Long> {

    int x = 5;

    @Override
    public Long call() throws Exception {
        return LongStream.rangeClosed(1, x).reduce((a,b) -> a *b).getAsLong();
    }
}