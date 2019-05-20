package com.myApp.concurrency.SynchronizedExample;

import com.myApp.concurrency.annotation.NotThreadSafe;
import com.myApp.concurrency.annotation.ThreadSafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@ThreadSafe
public class SynchronizedIntegerExample1 {
    // 请求总数
    public static int clientTotal = 5000;
    // 同时并发执行的线程数
    public static int threadTotal = 200;

    public static Integer count = new Integer(0);

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();//获取线程池
        final Semaphore semaphore = new Semaphore(threadTotal);//定义信号量
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    System.out.println("exception:" + e.toString());
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("count:" + count);

    }

    private static synchronized void add() {
        count++;
    }

}
