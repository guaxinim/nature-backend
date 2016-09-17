package com.guaxinim.nature.setup;

import org.neo4j.driver.v1.*;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.Produces;
import java.util.logging.Logger;

/**
 * Created by elvis on 16/09/2016.
 */
@Singleton
@Startup
public class Setup {

    Logger logger = Logger.getLogger(this.getClass().getName());

    private final org.neo4j.driver.v1.Driver driver;
    private String url = "localhost:7474";
    AuthToken token = AuthTokens.basic("admin", "raposa4");

    public Setup(Driver driver) {
        logger.fine("starting up Neo4J");
        this.driver = GraphDatabase.driver(url, token, Config.build().withEncryptionLevel(Config.EncryptionLevel.NONE).toConfig());
    }

    @Produces
    @Neo4jDriver
    public Driver getDriver() {
        return driver;
    }
}
