package com.guaxinim.nature.service;

import com.guaxinim.nature.domain.Action;
import com.guaxinim.nature.persistence.Neo4jGenericService;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local
public class ActionService extends Neo4jGenericService<Action> {

    public void insertAction(Action action) { createOrUpdate(action); }
    public void deleteAction(Long id) { delete(id); }
    public Iterable<Action> getActions() { return findAll(); }
    public Action getAction(String property, Long id) { return find(property, id); }
    public Class<Action> getEntityType() {
        return Action.class;
    }
}
