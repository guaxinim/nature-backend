package com.guaxinim.nature.service;

import com.guaxinim.nature.domain.Action;
import com.guaxinim.nature.persistence.Neo4jGenericService;

import javax.ejb.Stateless;

@Stateless
public class ActionService extends Neo4jGenericService<Action> {

    public void insertAction(Action action) {
        createOrUpdate(action);
    }

    @Override
    public Class<Action> getEntityType() {
        return Action.class;
    }
}
