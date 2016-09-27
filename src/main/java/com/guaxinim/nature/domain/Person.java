package com.guaxinim.nature.domain;

import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

public class Person extends Entity {

    private String name;
    private String relation;

    @Relationship(type = "DID")
    private Set<Action> actions;

    @Relationship(type = "HAD")
    private Set<Thought> thoughts;

    @Relationship(type = "HAD")
    private Set<Feeling> feelings;

    @Relationship(type = "HAD")
    private Set<Omission> omissions;

}
