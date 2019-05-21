package com.myApp.concurrency.PublishExample;

import com.myApp.concurrency.annotation.NotThreadSafe;

import java.util.Arrays;

@NotThreadSafe
public class UnsafePublish {
    private String[] states = {"a", "b", "c"};

    public String[] getStates() {
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        System.out.println(Arrays.toString(unsafePublish.states));

        unsafePublish.getStates()[0] = "d";//可以修改私有内容 可以在其他线程里修改【线程不安全】
        System.out.println(Arrays.toString(unsafePublish.states));
    }
}
