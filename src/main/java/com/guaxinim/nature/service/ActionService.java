package com.guaxinim.nature.service;

import com.guaxinim.nature.domain.Action;
import com.guaxinim.nature.persistence.Neo4jGenericService;

import javax.ejb.Stateless;
import java.util.Date;

@Stateless
public class ActionService extends Neo4jGenericService<Action> {

    public void saveAction(String strAction) {
        Action action = new Action();
        action.setWhen(new Date());
        action.setName(strAction);
        createOrUpdate(action);
    }

    @Override
    public Class<Action> getEntityType() {
        return Action.class;
    }
}
