package com.shengsiyuan.jvm.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyTest21 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16("loader2");
        loader1.setPath("D:\\java_study\\");
        loader2.setPath("D:\\java_study\\");
        // 删掉classpath下的Person类
        Class<?> clazz1 = loader1.loadClass("com.shengsiyuan.jvm.classloader.Person");
        Class<?> clazz2 = loader2.loadClass("com.shengsiyuan.jvm.classloader.Person");
        //  clazz1 和 clazz2 由loader1 和 loader2加载，结果为false
        System.out.println(clazz1 == clazz2);

        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();
        Method method = clazz1.getMethod("setPerson", Object.class);
        //此处报错， loader1和loader2所处不同的命名空间
        method.invoke(object1, object2);
    }
}
