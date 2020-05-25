package com.shengsiyuan.jvm.rename;

import java.io.File;

public class Rename {
    public static void main(String[] args) {
        File file = new File("E:\\张龙 圣思园\\springboot cloud");
        int count = 0;
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                String name = file1.getName();
                if (name.startsWith("Springbootcloud从入门到精通_")) {
                    name = name.substring(22);
                    count += 1;
                }
                File newFile = new File(file, name);
                System.out.println(newFile);
                file1.renameTo(newFile);
            }
        }
        System.out.println(count);

    }
}
