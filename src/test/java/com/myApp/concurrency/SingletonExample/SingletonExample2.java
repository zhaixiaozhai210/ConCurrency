package com.myApp.concurrency.SingletonExample;

import com.myApp.concurrency.annotation.ThreadSafe;

/**
 * 饿汉模式
 * 通过static的静态初始化方式，在该类第一次被加载的时候，就有一个SimpleSingleton的实例被创建出来了。
 * 这样就保证在第一次想要使用该对象时，他已经被初始化好了。
 * 由于该实例在类被加载的时候就创建出来了，所以也避免了线程安全问题。
 *
 * 缺点：
 * 饿汉式单例，在类被加载的时候对象就会实例化。
 * 这也许会造成不必要的消耗，因为有可能这个实例根本就不会被用到。
 * 而且，如果这个类被多次加载的话也会造成多次实例化。
 */
@ThreadSafe
public class SingletonExample2 {

    //1.私有的构造函数
    private SingletonExample2(){

    }

    //2.在类内部实例化一个实例
    private static SingletonExample2 instance = new SingletonExample2();

    //3.对外提供获取实例的静态方法
    public static SingletonExample2 getInstance(){
        return instance;
    }
}
