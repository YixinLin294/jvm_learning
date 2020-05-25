package com.shengsiyuan.jvm.classloader;

/**
 * 自定义类加载器加载类的卸载
 * -XX:+TraceClassUnloading
 *
 */
public class MyTest16_1 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        MyTest16 loader2 = new MyTest16("loader2");
        loader2.setPath("D:\\java_study\\");
        MyTest16.test(loader2);
        loader2 = null;
        System.gc(); // 让系统去显式执行垃圾回收
//         输出的两个对象hashcode值不同，因为前面加载的已经被卸载了
        loader2 = new MyTest16("loader6");
        loader2.setPath("D:\\java_study\\");
        MyTest16.test(loader2);

    }
}
