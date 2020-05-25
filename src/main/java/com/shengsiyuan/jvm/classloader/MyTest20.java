package com.shengsiyuan.jvm.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class MyTest20 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16("loader2");

        Class<?> clazz1 = loader1.loadClass("com.shengsiyuan.jvm.classloader.Person");

        Class<?> clazz2 = loader2.loadClass("com.shengsiyuan.jvm.classloader.Person");
        // clazz1和clazz均由应用类加载器加载的，第二次不会重新加载，结果为true
        System.out.println(clazz1 == clazz2);

        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setPerson", Object.class);
        method.invoke(object1, object2);

    }
}
