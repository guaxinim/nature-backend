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

}
