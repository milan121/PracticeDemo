package com.milanapp.practicedemo.Model;

public class Items {

    private String Name;
    private String SurName;


    public Items(String name, String surName) {
        Name = name;
        SurName = surName;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurName() {
        return SurName;
    }

    public void setSurName(String surName) {
        SurName = surName;
    }
}
