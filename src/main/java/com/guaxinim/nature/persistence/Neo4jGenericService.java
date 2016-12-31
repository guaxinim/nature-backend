package com.guaxinim.nature.persistence;

import com.guaxinim.nature.setup.neo4j.Neo4jSessionFactory;
import io.innerloop.neo4j.ogm.Session;

public abstract class Neo4jGenericService<T> implements Neo4jService<T> {

    private static final int DEPTH_LIST = 0;
    private static final int DEPTH_ENTITY = 1;
    private Session session = Neo4jSessionFactory.getInstance().getOGMSession();

    @Override
    public Iterable<T> findAll() {
        return session.loadAll(getEntityType());
    }

    @Override
    public T find(String property, Long id) {
        return session.load(getEntityType(), property, id);
    }

    @Override
    public void delete(Long id) { session.delete(getEntityType()); }

    @Override
    public void createOrUpdate(T entity) {
        session.save(entity);
    }

    public abstract Class<T> getEntityType();

    protected void clearSession() {
        session.clear();
    }
}
