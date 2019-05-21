package com.myApp.concurrency.PublishExample;

/**
 * 发布逸出
 * 在对象未完成构造的时候就可以被其他线程所发现
 */
public class EscapeExample {
    private int thisCanBeEscape = 0;

    public EscapeExample() {
        new InnerClass();
    }

    public class InnerClass{

        public InnerClass() {
            System.out.println(EscapeExample.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new EscapeExample();
    }
}
