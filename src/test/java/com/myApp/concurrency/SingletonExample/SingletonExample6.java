package com.myApp.concurrency.SingletonExample;

/**
 * 静态内部类
 * 这种方式能达到双检锁方式一样的功效，但实现更简单。
 * 对静态域使用延迟初始化，应使用这种方式而不是双检锁方式。
 */
public class SingletonExample6 {
    private SingletonExample6() {

    }

    private static class SingletonHolder {
        private static SingletonExample6 instance = new SingletonExample6();
    }

    public static SingletonExample6 getInstance() {
        return SingletonHolder.instance;
    }
}
