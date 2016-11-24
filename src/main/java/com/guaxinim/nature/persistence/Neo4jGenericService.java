package com.guaxinim.nature.persistence;

import com.guaxinim.nature.setup.neo4j.Neo4jSessionFactory;
import org.neo4j.ogm.session.Session;

public abstract class Neo4jGenericService<T> implements Neo4jService<T> {

    private static final int DEPTH_LIST = 0;
    private static final int DEPTH_ENTITY = 1;
    private Session session = Neo4jSessionFactory.getInstance().getOGMSession();

    @Override
    public Iterable<T> findAll() {
        System.out.println("     ############### Session: " + session);
        System.out.println("     ############### Type: " + getEntityType());
        return session.loadAll(getEntityType(), DEPTH_LIST);
    }
    @Override
    public T find(Long id) {
        return session.load(getEntityType(), id, DEPTH_ENTITY);
    }
    @Override
    public void delete(Long id) {
        session.delete(session.load(getEntityType(), id));
    }
    @Override
    public void createOrUpdate(T entity) {
        session.save(entity, DEPTH_ENTITY);
    }
    public abstract Class<T> getEntityType();

    protected void clearSession() {
        session.clear();
    }
}
