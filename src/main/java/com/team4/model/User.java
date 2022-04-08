package com.team4.model;

public class User {
    private int id;
    private String name;
    private String password;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

    public User() {
    }

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
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

<<<<<<< HEAD
    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
//hihihihihi
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

=======
>>>>>>> 70285c122a6a14d34f74703d5a13330a70e63144
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
