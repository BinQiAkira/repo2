package com.kaxi.entity;

public class Student {
    private int id;
    private String name;
    private int age;
    private int room_id;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public Student(int id, String name, int age, int room_id) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.room_id = room_id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", room_id=" + room_id +
                '}';
    }
}
