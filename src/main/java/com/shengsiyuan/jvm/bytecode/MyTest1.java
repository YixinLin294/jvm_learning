package com.shengsiyuan.jvm.bytecode;
/*

public class MyTest1 {
    private  int a = 1;
    public int getA() {
        return a;
    }
*/
/*    public void setA(int a) {
        this.a = a;
    }*//*

}
*/

public class MyTest1 {
    public static void main(String []args) {
        String str1 = "abc";
        String str2 = new String("def");
        String str3 = "abc";
        String str4 = str2.intern();
        String str5 = "def";
        System.out.println(str1 == str3);//true
        System.out.println(str2 == str4);//false
        System.out.println(str4 == str5);//true
    }
}
