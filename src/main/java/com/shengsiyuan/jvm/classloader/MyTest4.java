package com.shengsiyuan.jvm.classloader;

import java.util.Random;

/**
 * 对于数组实例来说，其类型是JVM在运行期动态生成的，表示为[Lcom.shengsiyuan.jvm.classloader.MyParent4 这种形式
 * 对于数组来说，JavaDoc将构成数据的元素称为Component, 实际上是将数组降低一个维度后的类型。
 *
 *助记符： anewarray: 表示创建一个引用类型（如类，接口）的数组，并将其引用值压入栈顶
 * 助记符：newarray： 表示创建一个指定原始类型（int boolean float double)的数组，并将其引用值压入栈顶
 */

public class MyTest4 {
    public static void main(String[] args) {
//        MyParent4 myParent4 = new MyParent4(); //创建类的实例，属于主动使用，会导致类的初始化
        System.out.println("11111111");
        MyParent4[] myParent4s = new MyParent4[1]; // 不是主动使用
        System.out.println("22222222");
        System.out.println(myParent4s.getClass());
        System.out.println("33333333");
        System.out.println(myParent4s.getClass().getSuperclass());
        System.out.println("44444444");
        int[] i = new int[1];
        System.out.println(i.getClass());
        System.out.println(i.getClass().getSuperclass());
    }
}


class MyParent4 {
    static {
        System.out.println("MyParent static block");
    }
}
