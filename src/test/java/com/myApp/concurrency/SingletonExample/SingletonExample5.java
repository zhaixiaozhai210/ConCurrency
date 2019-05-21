package com.myApp.concurrency.SingletonExample;

import com.myApp.concurrency.annotation.ThreadSafe;

/**
 * 双重检测机制(DCL)懒汉式
 * volatile关键字其另一个特性：禁止指令重排序优化，保证多个线程可以正确处理单件实例
 */
@ThreadSafe
public class SingletonExample5 {
    private SingletonExample5() {

    }

    private static volatile SingletonExample5 instance = null;

    public static SingletonExample5 getInstance() {
        if (instance == null) {//双重检验instance
            synchronized (SingletonExample5.class) {//为需要初始化的情况加锁
                if (instance == null) {
                    instance = new SingletonExample5();
                }
            }
        }
        return instance;
    }
}
