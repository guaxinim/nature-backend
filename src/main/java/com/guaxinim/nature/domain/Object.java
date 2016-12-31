package com.guaxinim.nature.domain;

import io.innerloop.neo4j.ogm.annotations.Id;

public class Object extends Entity {

    @Id
    private Long uuid;
    private String name;
    private String type;

    public Object() { }
    public Object(String name) {
        this.name = name;
    }
    public Object(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Long getUuid() { return uuid; }

    public void setUuid(Long uuid) { this.uuid = uuid; }

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
