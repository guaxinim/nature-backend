package com.guaxinim.nature.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Object {

    public Object() {
    }

    @GraphId
    private Long id;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || id == null || getClass() != o.getClass()) return false;
        Object entity = (Object) o;
        if (!id.equals(entity.id)) return false;
        return true;
    }

    public int hashCode() {
        return (id == null) ? -1 : id.hashCode();
    }

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
