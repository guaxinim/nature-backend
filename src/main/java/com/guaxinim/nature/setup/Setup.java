package com.guaxinim.nature.setup;

import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.AuthToken;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Config;

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
    private String url;
    private AuthToken token;

    public Setup() {
        logger.fine("starting up Neo4J");
        url = "localhost:7474";
        token = AuthTokens.basic("admin", "raposa4");
    }

    @Produces
    @Neo4jDriver
    public Driver getDriver() {
        //TODO: Check if is correct obtain a new driver in every production
        return GraphDatabase.driver(url, token, Config.build().withEncryptionLevel(Config.EncryptionLevel.NONE).toConfig());
    }
}
