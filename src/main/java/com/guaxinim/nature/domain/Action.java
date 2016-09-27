package com.guaxinim.nature.domain;

import org.neo4j.ogm.annotation.typeconversion.DateLong;

import java.util.Date;

public class Action extends Entity {

    private String name;
    @DateLong
    private Date when;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getWhen() {
        return when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }
}
