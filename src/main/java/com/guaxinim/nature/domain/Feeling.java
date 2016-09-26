package com.guaxinim.nature.domain;

import org.neo4j.ogm.annotation.typeconversion.DateLong;

import java.util.Date;

public class Feeling extends Entity {

    private String name;
    @DateLong
    private Date when;
}
