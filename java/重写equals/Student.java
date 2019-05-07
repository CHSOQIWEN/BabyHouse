package com.bittch;

/**
 * Auther:CHAOQIWEN
 */
public class Student {
    private String name;
    private  int id;
    private int  age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    //重写equals方法，根据对象的属性值判别对象是否相等
    @Override
    public boolean equals(Object obj) {
        //判断参数是否是当前类的实例，如果不是则不相等
        if(!(obj instanceof Student)){
            return false;
        }

        if(obj==this){
            return true;
        }
        //比较传入对象的属性值与当前对象的属性值
        Student student=(Student) obj;//强制转型
        return student.getName().equals(this.getName())&&
                student.getAge()==this.getAge()&&
                student.getId()==this.getId();
    }
}
