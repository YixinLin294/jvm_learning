package com.shengsiyuan.jvm.bytecode;

public class MyTest4{
    public static void test(){
        System.out.println("static test");
    }
    public static void main(String[] args){
        test();             //invokestatic
    }
}
