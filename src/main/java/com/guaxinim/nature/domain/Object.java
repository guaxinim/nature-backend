package com.guaxinim.nature.domain;

public class Object extends Entity {

    private String name;
    private String type;

    public Object(String name) {
        this.name = name;
    }

    public Object(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
