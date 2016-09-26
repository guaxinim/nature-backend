package com.guaxinim.nature.domain;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public abstract class Entity {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //TODO: Implement equals and hashcode
}
