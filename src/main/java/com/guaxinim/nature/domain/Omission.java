package com.guaxinim.nature.domain;

import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateLong;

import java.util.Date;
import java.util.Set;

public class Omission extends Entity {

    private String name;
    @DateLong
    private Date when;

    @Relationship(type = "HAD_FROM", direction = Relationship.INCOMING)
    private Set<Person> person;

}