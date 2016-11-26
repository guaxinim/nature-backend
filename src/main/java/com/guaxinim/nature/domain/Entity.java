package com.guaxinim.nature.domain;

import org.neo4j.ogm.annotation.NodeEntity;

import java.lang.*;

@NodeEntity
public abstract class Entity {

    private Long id;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (o == null || id == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        if (!id.equals(entity.id)) return false;
        return true;
    }

    public int hashCode() {
        return (id == null) ? -1 : id.hashCode();
    }
}
