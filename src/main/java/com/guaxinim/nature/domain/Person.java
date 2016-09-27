package com.guaxinim.nature.domain;

import java.util.Set;

public class Person extends Entity {

    private String name;
    private String relation;
    private Set<Action> actions;
    private Set<Thought> thoughts;
    private Set<Feeling> feelings;
    private Set<Omission> omissions;

}
