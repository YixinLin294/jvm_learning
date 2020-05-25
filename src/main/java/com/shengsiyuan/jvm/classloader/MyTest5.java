package com.shengsiyuan.jvm.classloader;

import java.util.Random;
import java.util.UUID;

public class MyTest5 {
    public static void main(String[] args) {
        System.out.println(MyChild5.interfaceTest2);
    }
}

interface MyParent5 {
    public static InterfaceTest interfaceTest1= new InterfaceTest("MyParent5");
}

class  MyChild5 implements MyParent5 {
    public static InterfaceTest interfaceTest2 = new InterfaceTest("MyChild5");
    public static final int b = new Random().nextInt();
}

class InterfaceTest {
    private String who;
    public InterfaceTest(String who) {
        this.who = who;
        System.out.println(this.who + " invoke");
    }
}
