package com.guaxinim.nature.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.typeconversion.DateLong;

import java.util.Date;

@NodeEntity
public class Thought {

    private Long id;
    private String name;
    @DateLong
    private Date when;
}
