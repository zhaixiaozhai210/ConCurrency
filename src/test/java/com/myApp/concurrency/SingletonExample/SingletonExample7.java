package com.myApp.concurrency.SingletonExample;

import com.myApp.concurrency.annotation.ThreadSafe;

/**
 * 枚举模式
 */
@ThreadSafe
public class SingletonExample7 {

    private SingletonExample7(){

    }

    public SingletonExample7 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{
        INSTANCE;

        private SingletonExample7 singleton ;

        Singleton(){
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getInstance(){
            return singleton;
        }
    }
}
