package com.shengsiyuan.jvm.classloader;

/**
 * 准备阶段和初始化的顺序问题
 */
public class MyTest6 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(Singleton.counter1);
        System.out.println(Singleton.counter2);
    }
}

class Singleton {
    public static int counter1;
//    public static int counter2 = 0;
    private static Singleton singleton = new Singleton();

    private Singleton() {
        counter1++;
        counter2++;
    }

    public static int counter2 = 0;
    public static Singleton getInstance() {
        return singleton;
    }

}
