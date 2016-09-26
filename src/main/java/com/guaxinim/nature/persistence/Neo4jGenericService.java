package com.guaxinim.nature.persistence;


import com.guaxinim.nature.domain.Entity;
import com.guaxinim.nature.setup.neo4j.Neo4jSessionFactory;
import org.neo4j.ogm.session.Session;

public abstract class Neo4jGenericService<T> implements Neo4jService<T> {

    private static final int DEPTH_LIST = 0;
    private static final int DEPTH_ENTITY = 1;
    private Session session = Neo4jSessionFactory.getInstance().getNeo4jSession();

    @Override
    public Iterable<T> findAll() {
        return session.loadAll(getEntityType(), DEPTH_LIST);
    }
    @Override
    public T find(Long id) {
        return session.load(getEntityType(), id, DEPTH_ENTITY); }
    @Override
    public void delete(Long id) { session.delete(session.load(getEntityType(), id));
    }
    @Override
    public T createOrUpdate(T entity) { session.save(entity, DEPTH_ENTITY);
        return find(((Entity) entity).getId()); }
    public abstract Class<T> getEntityType(); }
