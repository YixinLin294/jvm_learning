package com.shengsiyuan.jvm.classloader;

/**
 *  对于静态字段来说，只有直接定义了该字段的类才会被初始化
 *  当一个类在初始化时，要求父类全部都已经初始化完毕
 *  -XX:+TraceClassLoading, 用于追踪类的加载信息并打印出来
 *
 *  -XX:+<option>, 表示开启option选项
 *  -XX:-<option>, 表示关闭option选项
 *  -XX:<option>=value, 表示将option的值设置为value
 *
 */

public class MyTest {
    public static void main(String[] args) {
//        System.out.println(MyChild.str);
        System.out.println(MyChild.str2);
    }

}

class MyParent {
    public static String str = "hello world";

    static {
        System.out.println("MyParent static block");
    }
}

class MyChild extends MyParent{
    public static String str2 = "welcome";

    static {
        System.out.println("MyChild static block");
    }
}
