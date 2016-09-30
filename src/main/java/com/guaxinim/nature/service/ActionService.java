package com.guaxinim.nature.service;

import com.guaxinim.nature.domain.Action;
import com.guaxinim.nature.persistence.Neo4jGenericService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Date;

@Stateless
public class ActionService {

    @Inject
    Neo4jGenericService<Action> service;

    public void saveAction(String strAction) {
        Action action = new Action();
        action.setWhen(new Date());
        action.setName(strAction);
        service.createOrUpdate(action);
    }

}
