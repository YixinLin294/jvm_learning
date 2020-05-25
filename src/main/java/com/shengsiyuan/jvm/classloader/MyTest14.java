package com.shengsiyuan.jvm.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class MyTest14 {
    public static void main(String[] args) throws IOException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader);
        String resourceName = "com/shengsiyuan/jvm/classloader/Mytest13.class";
        Enumeration<URL> urls = loader.getResources(resourceName);
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            System.out.println(url);
        }
    }
}
