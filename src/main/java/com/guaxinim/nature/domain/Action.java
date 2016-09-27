package com.guaxinim.nature.domain;

import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateLong;

import java.util.Date;
import java.util.Set;

public class Action extends Entity {

    private String name;

    @DateLong
    private Date when;

    @Relationship(type = "DID_BY", direction = Relationship.INCOMING)
    private Set<Person> didBy;

    @Relationship(type = "TO")
    private Set<Person> toSmb;

    @Relationship(type = "TO")
    private Set<Object> toSmt;

    @Relationship(type = "WITH")
    private Set<Object> smt;

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

    public Set<Person> getDidBy() {
        return didBy;
    }

    public void setDidBy(Set<Person> didBy) {
        this.didBy = didBy;
    }

    public Set<Person> getToSmb() {
        return toSmb;
    }

    public void setToSmb(Set<Person> toSmb) {
        this.toSmb = toSmb;
    }

    public Set<Object> getToSmt() {
        return toSmt;
    }

    public void setToSmt(Set<Object> toSmt) {
        this.toSmt = toSmt;
    }

    public Set<Object> getSmt() {
        return smt;
    }

    public void setSmt(Set<Object> smt) {
        this.smt = smt;
    }
}
