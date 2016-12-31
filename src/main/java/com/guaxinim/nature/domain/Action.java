package com.guaxinim.nature.domain;

import io.innerloop.neo4j.ogm.annotations.Id;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateLong;

import java.util.Date;
import java.util.Set;

public class Action extends Entity {

    @Id
    private Long uuid;
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
    private Set<Object> withSmt;

    @Relationship(type = "WITH")
    private Set<Person> withSmb;

    public Long getUuid() { return uuid; }

    public void setUuid(Long uuid) { this.uuid = uuid; }

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

    public Set<Object> getWithSmt() {
        return withSmt;
    }

    public void setWithSmt(Set<Object> withSmt) {
        this.withSmt = withSmt;
    }

    public Set<Person> getWithSmb() {
        return withSmb;
    }

    public void setWithSmb(Set<Person> withSmb) {
        this.withSmb = withSmb;
    }
}
