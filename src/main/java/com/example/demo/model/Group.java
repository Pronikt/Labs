package com.example.demo.model;

public class Group {
    private int id_s_gr;
    private String name;

    public Group(int id, String name){
        this.id_s_gr = id;
        this.name = name;
    }

    public int getId() {
        return id_s_gr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id_s_gr = id;
    }

    public String getName() {
        return name;
    }
}
