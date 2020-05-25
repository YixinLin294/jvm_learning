package com.shengsiyuan.jvm.classloader;

/**
 * 调用ClassLoader的loaderClass方法加载一个类，并不是对类的主动使用，不会导致类的初始化
 */
public class MyTest8 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class<?> clazz1 = loader.loadClass("com.shengsiyuan.jvm.classloader.CL");
        System.out.println(clazz1);
        System.out.println("----------------");

        Class<?> clazz = Class.forName("com.shengsiyuan.jvm.classloader.CL");
        System.out.println(clazz);

    }
}

class CL {
    static {
        System.out.println("FinalTest static block");
    }
}
