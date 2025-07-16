package org.reflection.model;

public class Student {

    private int id;
    private String name;

    public Student(){
        System.out.println("Student creating....");
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    private void studentClassInfo(){
        System.out.println("studentClassInfo: This method provides general student class information.");
        System.out.println("Class Name: " + this.getClass().getName());
    }

    private Student studentInfo(int id,String name){
        return new Student(id,name);
    }

}
