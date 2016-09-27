package com.guaxinim.nature.domain;

import org.neo4j.ogm.annotation.typeconversion.DateLong;

import java.util.Date;

public class Feeling extends Entity {

    private String what;
    @DateLong
    private Date when;
}
