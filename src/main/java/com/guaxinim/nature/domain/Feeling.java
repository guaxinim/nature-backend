package com.guaxinim.nature.domain;

import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateLong;

import java.util.Date;
import java.util.Set;

public class Feeling extends Entity {

    private String what;
    @DateLong
    private Date when;

    @Relationship(type = "FELT_BY", direction = Relationship.INCOMING)
    private Set<Person> person;
}
