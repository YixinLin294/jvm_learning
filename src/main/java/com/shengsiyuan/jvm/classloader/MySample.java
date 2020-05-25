package com.shengsiyuan.jvm.classloader;


public class MySample {
    public MySample() {
        System.out.println("MySample is loaded..."  + this.getClass().getClassLoader());
        new MyCat();
        System.out.println("from MySample:" + MyCat.class);
    }
}
