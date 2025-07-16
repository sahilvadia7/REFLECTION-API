package org.reflection.model;

public class ClassRoom {

    private Long id;
    private String name;

    private ClassRoom(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    private ClassRoom(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    private String classInfo(){
        return "Class Info Called";
    }


    @Override
    public String toString() {
        return "ClassRoom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
