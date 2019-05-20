package com.myApp.concurrency.SynchronizedExample;

import com.myApp.concurrency.annotation.ThreadSafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 执行结果
 * test1:  0
 * test1:  1
 * test1:  2
 * test1:  3
 * test1:  4
 * test1:  5
 * test1:  6
 * test1:  7
 * test1:  8
 * test1:  9
 * test1:  0
 * test1:  1
 * test1:  2
 * test1:  3
 * test1:  4
 * test1:  5
 * test1:  6
 * test1:  7
 * test1:  8
 * test1:  9
 * 在多线程下，两个线程同时作用于一个对象时，该代码块被先抢到资源的进程执行结束后另一个线程才得以执行。
 * synchronized修饰代码块,作用于调用的对象
 * synchronized修饰的方法,作用于调用的对象
 */
@ThreadSafe
public class SynchronizedIntegerExample2 {
    //synchronized修饰代码块
    public void test1() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println("test1:  "+i);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();//获取线程池

        SynchronizedIntegerExample2 syn1 = new SynchronizedIntegerExample2();
        executorService.execute(() -> {
            syn1.test1();
        });

        executorService.execute(() -> {
            syn1.test1();
        });
    }
}
