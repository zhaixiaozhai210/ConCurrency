package com.myApp.concurrency.SingletonExample;

import com.myApp.concurrency.annotation.ThreadSafe;

/**
 * 饿汉模式 -- 静态代码块
 */
@ThreadSafe
public class SingletonExample3 {

    private SingletonExample3() {

    }

    private static SingletonExample3 instance = null;

    static {
        instance = new SingletonExample3();
    }

    public static SingletonExample3 getInstance() {
        return instance;
    }

}
