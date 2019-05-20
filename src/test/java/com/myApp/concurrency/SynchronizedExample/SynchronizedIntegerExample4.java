package com.myApp.concurrency.SynchronizedExample;

import com.myApp.concurrency.annotation.NotThreadSafe;
import com.myApp.concurrency.annotation.ThreadSafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
 * test2:  0
 * test1:  8
 * test1:  9
 * test2:  1
 * test2:  2
 * test2:  3
 * test2:  4
 * test2:  5
 * test2:  6
 * test2:  7
 * test2:  8
 * test2:  9
 * 对于两个线程分别调用两个对象时，并没有锁的出现，线程交叉执行并输出。
 * synchronized修饰代码块,作用于调用的对象
 * synchronized修饰的方法,作用于调用的对象
 */
@NotThreadSafe
public class SynchronizedIntegerExample4 {
    //synchronized修饰代码块
    public void test1() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println("test1:  "+i);
            }
        }
    }
    //synchronized修饰方法
    public synchronized void test2(){
        for (int i = 0; i < 10; i++) {
            System.out.println("test2:  "+i);
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();//获取线程池

        SynchronizedIntegerExample4 syn1 = new SynchronizedIntegerExample4();
        SynchronizedIntegerExample4 syn2 = new SynchronizedIntegerExample4();
        executorService.execute(() -> {
            syn1.test1();
        });

        executorService.execute(() -> {
            syn2.test1();
        });
    }
}
