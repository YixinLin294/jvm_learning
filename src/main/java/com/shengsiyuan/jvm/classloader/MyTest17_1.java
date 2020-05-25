package com.shengsiyuan.jvm.classloader;

import java.io.*;

public class MyTest17_1 extends ClassLoader {
    private String classLoaderName;
    private String path;
    private final String fileExtension=".class";

    public MyTest17_1(String classLoaderName) {
        super(); // 将系统类当作该类的父加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest17_1(ClassLoader parent, String classLoaderName) {
        super(parent); // 显式指定该类的父加载器
        this.classLoaderName = classLoaderName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String className) {
        System.out.println("className="+className);
        String className1 = className.replace(".", File.separator);
        byte[] data = loadClassData(className1);
        return defineClass(className, data, 0, data.length);
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

/*    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyTest17_1 loader1 = new MyTest17_1("loader1");
        loader1.path = "D:\\java_study\\";
        Class<?> clazz = loader1.loadClass("com.shengsiyuan.jvm.classloader.MySample");
        System.out.println(clazz.hashCode());
        // MyCat 是有加载MySample的加载器去加载的：
        // 如果只删除classpath下的MyCat，则会报错， NoClassDefFoundError
//         如果只删除classpath下的MySample，则由自定义加载器加载桌面上的MySample， 由系统/应用类加载器加载MyCat
        Object object = clazz.newInstance();
    }*/

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 修改MyCat后，仍然删除classpath下的MySample，留下MyCat，程序报错
        // 因为命名空间，父加载器加载不到子加载器所加载的类，因此MyCat找不到MySample
        MyTest17_1 loader1 = new MyTest17_1("loader1");
        loader1.path = "D:\\java_study\\";
        Class<?> clazz = loader1.loadClass("com.shengsiyuan.jvm.classloader.MySample");
        System.out.println(clazz.hashCode());
        Object object = clazz.newInstance();
    }
}
