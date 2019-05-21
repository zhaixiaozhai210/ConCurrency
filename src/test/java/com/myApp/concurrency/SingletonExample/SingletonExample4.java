package com.myApp.concurrency.SingletonExample;

import com.myApp.concurrency.annotation.ThreadSafe;

/**
 * 懒汉模式 线程安全做法 synchronized
 * 缺点：
 * 效率低,开销大
 */
@ThreadSafe
public class SingletonExample4 {
    private SingletonExample4() {

    }

    private static SingletonExample4 instance = null;

    //对该方法加锁
    public static synchronized SingletonExample4 getInstance(){
        if (instance == null){
            instance = new SingletonExample4();
        }
        return instance;
    }
}
