package com.guaxinim.nature.setup.neo4j;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.ogm.authentication.Credentials;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class Neo4jSessionFactory {

    Logger logger = Logger.getLogger(this.getClass().getName());
    private static Neo4jSessionFactory factory = new Neo4jSessionFactory();
    Properties properties;
    //public static final String URL = System.getenv("NEO4J_URL") != null ? System.getenv("NEO4J_URL") : "http://localhost:7474";

    public static Neo4jSessionFactory getInstance() {
        return factory;
    }

    private Neo4jSessionFactory() {
        try (InputStream stream = ClassLoader.getSystemResourceAsStream("settings.properties")) {
            properties.load(stream);
            stream.close();
        } catch (IOException ioex) {
            logger.severe("Error loading settings.properties");
            throw new RuntimeException(ioex);
        }
    }

    public org.neo4j.ogm.config.Configuration getConfiguration() {
        org.neo4j.ogm.config.Configuration config = new org.neo4j.ogm.config.Configuration();
        config
                .driverConfiguration()
                .setDriverClassName("org.neo4j.ogm.drivers.http.driver.HttpDriver")
                .setURI(properties.getProperty("neo4j.url"))
                .setCredentials(properties.getProperty("neo4j.username"), properties.getProperty("neo4j.password"));
        return config;
    }

    public Session getNeo4jSession() {
        SessionFactory sessionFactory = new SessionFactory(getConfiguration(), "default.domain");
        return sessionFactory.openSession();
    }
}