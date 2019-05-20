package com.myApp.concurrency.SynchronizedExample;

import com.myApp.concurrency.annotation.NotThreadSafe;
import com.myApp.concurrency.annotation.ThreadSafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * [1]test1:  0
 * [1]test1:  1
 * [1]test1:  2
 * [1]test1:  3
 * [1]test1:  4
 * [1]test1:  5
 * [1]test1:  6
 * [1]test1:  7
 * [1]test1:  8
 * [1]test1:  9
 * [2]test1:  0
 * [2]test1:  1
 * [2]test1:  2
 * [2]test1:  3
 * [2]test1:  4
 * [2]test1:  5
 * [2]test1:  6
 * [2]test1:  7
 * [2]test1:  8
 * [2]test1:  9
 * 在两个线程调用一个类的不同对象时，仍然能保证原子性。
 * synchronized修饰的静态方法,作用于这个类的所有对象
 * synchronized修饰的类,作用于这个类的所有对象
 */
@ThreadSafe
public class SynchronizedIntegerExample6 {
    //synchronized修饰静态方法
    public static synchronized void test2(int x){
        for (int i = 0; i < 10; i++) {
            System.out.print("[" + x + "]");
            System.out.println("test2:  "+i);
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();//获取线程池

        SynchronizedIntegerExample6 syn1 = new SynchronizedIntegerExample6();
        SynchronizedIntegerExample6 syn2 = new SynchronizedIntegerExample6();
        executorService.execute(() -> {
            syn1.test2(1);
        });

        executorService.execute(() -> {
            syn2.test2(2);
        });
    }
}
