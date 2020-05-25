package com.shengsiyuan.jvm.classloader;

public class MyTest22 {
    static {
        System.out.println("MyTest22 init...");
    }

    public static void main(String[] args) {
        System.out.println(MyTest22.class.getClassLoader());

        System.out.println(MyTest.class.getClassLoader());
    }


}
