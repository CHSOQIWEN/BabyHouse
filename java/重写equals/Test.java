package com.bittch;

/**
 * Auther:CHAOQIWEN
 */
public class Test {
    public static void main(String[] args) {
            Student student1=new Student("zhangsan",001,20);
            Student student2=new Student("zhangsan",001,20);
            Student student3=new Student("lisi",003,20);
            System.out.println(student1.equals(student2));
            System.out.println(student1.equals(student3));



    }
}
