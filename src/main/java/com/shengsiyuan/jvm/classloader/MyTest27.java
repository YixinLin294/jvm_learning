package com.shengsiyuan.jvm.classloader;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ServiceLoader;

public class MyTest27 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.jdbc.Driver"); // 由于ServiceLoader机制的存在，此行可以注释掉不影响
        Connection connection = DriverManager.getConnection("jdbc:mysql://loaclhost:3306/mydb", "root", "123456");
    }
}
