package com.shengsiyuan.jvm.classloader;

import java.io.*;
import java.sql.SQLOutput;

/**
 * 创建自定义加载其，继承ClassLoader
 */
public class MyTest16 extends ClassLoader{
    private String classLoaderName;
    private String path;
    private final String fileExtension = ".class";

    public MyTest16(String classLoaderName) {
        super();  // 将系统类当作该类的父加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent, String classLoaderName) {
        super(parent); // 显示指定该类的父加载器
        this.classLoaderName=classLoaderName;
    }

    public MyTest16(ClassLoader parent) {
        super(parent);  // 显示指定该类的父加载器
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String className) {
        System.out.println("className=" + className);
        String className1 = className.replace(".", File.separator);
        byte[] data = loadClassData(className1);
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

    public static void test(ClassLoader classLoader) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = classLoader.loadClass("com.shengsiyuan.jvm.classloader.MyTest");
        // loadClass 是父类方法，在方法内部调用findClass
        System.out.println(clazz.hashCode());
        Object object = clazz.newInstance();
        System.out.println(object);
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
/*        // 父亲是系统类加载器，根据双亲委托机制，MyTest1由系统类加载器加载了
        MyTest16 loader1 = new MyTest16("loader1");
        test(loader1);
        System.out.println("-----------------");;

        // 仍然是系统类加载器进行加载的，因为路径正好是classpath
        MyTest16 loader2 = new MyTest16("loader2");
        loader2.path = "D:\\java_study\\jvm_lecture\\out\\production\\classes\\";
        test(loader2);
        System.out.println("--------------------");*/

        // 自定义的类加载器被执行，findClass方法下的 输出被打印。前提是当前classpath下不存在MyTest
        MyTest16 loader3 = new MyTest16("loader3");
        loader3.path = "D:\\java_study\\";
        test(loader3);

        // 与3同时存在，输出两个class的hash不一致，findClass方法下的输出均被打印，原因是类加载器的命名空间问题。
        MyTest16 loader4 = new MyTest16("loader4");
        loader4.path = "D:\\java_study\\";
        test(loader4);

        // 将loader3作为父加载器
        MyTest16 loader5 = new MyTest16(loader3, "loader3");
        loader5.path = "D:\\java_study\\";
        test(loader5);
    }
}
