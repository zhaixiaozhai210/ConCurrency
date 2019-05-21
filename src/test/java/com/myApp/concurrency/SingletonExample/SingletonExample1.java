package com.myApp.concurrency.SingletonExample;

import com.myApp.concurrency.annotation.NotThreadSafe;

/**
 * 懒汉模式
 * 当有多个线程并行调用 getInstance()的时候，就会创建多个实例。也就是说在多线程下不能正常工作
 */
@NotThreadSafe
public class SingletonExample1 {
    //1.私有构造函数
    private SingletonExample1(){

    }
    //2.初始化一个对象引用
    private static SingletonExample1 instance = null;

    //3.对外提供的获取实例的方法
    public static SingletonExample1 getInstance(){
        //对象被引用时才实例化
        if (instance == null){
            instance = new SingletonExample1();
        }
        return instance;
    }
}
