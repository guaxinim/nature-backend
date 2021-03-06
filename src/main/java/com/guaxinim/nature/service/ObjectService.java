package com.guaxinim.nature.service;

import com.guaxinim.nature.domain.Object;
import com.guaxinim.nature.persistence.Neo4jGenericService;

import javax.annotation.PreDestroy;
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

    @PreDestroy
    public void closeSession() {
        clearSession();
    }

    @Override
    public Object find(String property, Long id) {
        return super.find(property, id);
    }
}
