package com.neelanjan.deliveryprovider.entity;

public class Delivery {
    private int id;
    private String name;
    private String status;

   
    public Delivery(int i, String string, String string2, String string3) {
    }

    public Delivery(int id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    // Getters and Setters
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

