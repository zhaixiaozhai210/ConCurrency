package com.myApp.concurrency.threadLocal;

/**
 * 创建一个包含ThreadLocal对象的类，并提供基础的添加、删除、获取操作。
 */
public class RequestHolder {

    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<Long>();

    public static void add(Long id){
        requestHolder.set(id);
    }

    public static Long get(){
        return requestHolder.get();
    }

    public static void remove(){
        requestHolder.remove();
    }
}
