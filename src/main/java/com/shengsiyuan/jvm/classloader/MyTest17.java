package com.shengsiyuan.jvm.classloader;

import java.io.*;

/**
 * 创建自定义加载器，继承ClassLoader
 */

public class MyTest17 extends ClassLoader{
    private String classLoaderName;
    private String path;
    private final String fileExtension = ".class";

    public MyTest17(String classLoaderName) {
        super(); // 将系统当做该类的父加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest17(ClassLoader parent, String classLoaderName) {
        super(parent); // 显式指定该类的父加载器
        this.classLoaderName = classLoaderName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String className) {
        System.out.println("className = " + className);
        className = className.replace(".", File.separator);
        byte[] data = loadClassData(className);
        return defineClass(className, data, 0, data.length); // define方法为父类方法
    }

    private byte[] loadClassData(String className) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        try {
            is = new FileInputStream(new File(this.path + className + this.fileExtension));
            baos = new ByteArrayOutputStream();
            int ch;
            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }
            data = baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                return data;
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyTest17 loader1 = new MyTest17("loader1");
        Class<?> clazz = loader1.loadClass("com.shengsiyuan.jvm.classloader.MySample");
        System.out.println(clazz.hashCode());
        // 如果注释掉该行，就不会实例化MySample对象，不会加载MyCat（可能预先加载）
//        Object object = clazz.newInstance(); //加载和实例化了MySample和MyCat
    }
}

