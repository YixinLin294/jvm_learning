package com.shengsiyuan.jvm.classloader;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

public class MyTest26 {
    public static void main(String[] args) {
        // 一旦加入下面此行，将使用ExtClassLoader去加载Driver.class, ExtClassLoader不会去加载classpath，因此无法找到MySql的相关驱动。
        Thread.currentThread().setContextClassLoader(MyTest26.class.getClassLoader().getParent());

        // ServiceLoader服务提供者，加载实现的服务
        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = loader.iterator();
        while (iterator.hasNext()) {
            Driver driver = iterator.next();
            System.out.println("driver:" + driver.getClass() +
                    ", loader" + driver.getClass().getClassLoader());
        }
        System.out.println("当前上下文加载器" + Thread.currentThread().getContextClassLoader());
        System.out.println("ServiceLoader的加载器" + ServiceLoader.class.getClassLoader());
    }
}
