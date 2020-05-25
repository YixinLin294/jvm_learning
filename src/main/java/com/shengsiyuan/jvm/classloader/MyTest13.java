package com.shengsiyuan.jvm.classloader;

/**
 * 输出AppClassLoader、ExtClassLoader、null
 */

public class MyTest13 {
    public static void main(String[] args) {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        System.out.println(loader);

        while (loader != null) {
            loader = loader.getParent();
            System.out.println(loader);
        }
    }
}
