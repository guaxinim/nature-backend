package com.guaxinim.nature.service;

import com.guaxinim.nature.domain.Object;
import com.guaxinim.nature.persistence.Neo4jGenericService;
import javax.ejb.Stateless;

@Stateless
public class ObjectService extends Neo4jGenericService<Object> {

    public void insertObject(Object object) {
        createOrUpdate(object);
    }

    public Iterable<Object> getObjects() {
        return findAll();
    }

    @Override
    public Class<Object> getEntityType() {
        return Object.class;
    }
}
