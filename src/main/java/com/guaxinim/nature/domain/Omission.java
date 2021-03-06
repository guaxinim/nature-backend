package com.guaxinim.nature.domain;

import io.innerloop.neo4j.ogm.annotations.Id;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateLong;

import java.util.Date;
import java.util.Set;

public class Omission extends Entity {

    @Id
    private Long uuid;
    private String name;
    @DateLong
    private Date when;

    @Relationship(type = "HAD_FROM", direction = Relationship.INCOMING)
    private Set<Person> person;

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

    public Set<Person> getPerson() {
        return person;
    }

    public void setPerson(Set<Person> person) {
        this.person = person;
    }
}
