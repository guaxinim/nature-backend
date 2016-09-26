package com.guaxinim.nature.persistence;

public interface Neo4jService<T> {
    Iterable<T> findAll();
    T find(Long id);
    void delete(Long id);
    T createOrUpdate(T object);
}