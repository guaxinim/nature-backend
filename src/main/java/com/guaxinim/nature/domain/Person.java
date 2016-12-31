package com.guaxinim.nature.domain;

import io.innerloop.neo4j.ogm.annotations.Id;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

public class Person extends Entity {

    @Id
    private Long uuid;

    public Long getUuid() { return uuid; }
    public void setUuid(Long uuid) { this.uuid = uuid; }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public Set<Action> getActions() {
        return actions;
    }

    public void setActions(Set<Action> actions) {
        this.actions = actions;
    }

    public Set<Thought> getThoughts() {
        return thoughts;
    }

    public void setThoughts(Set<Thought> thoughts) {
        this.thoughts = thoughts;
    }

    public Set<Feeling> getFeelings() {
        return feelings;
    }

    public void setFeelings(Set<Feeling> feelings) {
        this.feelings = feelings;
    }

    public Set<Omission> getOmissions() {
        return omissions;
    }

    public void setOmissions(Set<Omission> omissions) {
        this.omissions = omissions;
    }
}
