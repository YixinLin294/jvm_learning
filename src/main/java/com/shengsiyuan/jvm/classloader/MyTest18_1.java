package com.shengsiyuan.jvm.classloader;

public class MyTest18_1 {
    public static void main(String[] args) throws ClassNotFoundException {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("D:\\java_study\\");

        // 把MyTest1.class文件放入到根类加载器路径中，则有根类加载器加载MyTest1
        Class<?> clazz = loader1.loadClass("com.shengsiyuan.jvm.classloader.MyTest");

        System.out.println("clazz:" + clazz.hashCode());
        System.out.println("clazz loader: " + clazz.getClassLoader());
    }
}
