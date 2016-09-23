package com.guaxinim.nature.setup;

import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.AuthToken;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Config;

import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import java.util.logging.Logger;


@Stateless
@Startup
public class Setup {

    Logger logger = Logger.getLogger(this.getClass().getName());
    private String url;
    private AuthToken token;
    private Driver driver;

    public Setup() {
        logger.fine("starting up Neo4J");
        url = "bolt://localhost";
        token = AuthTokens.basic("neo4j", "12345678");
    }

    @Produces
    @Neo4jDriver
    public Driver getDriver() {
        //TODO: Check if is correct obtain a new driver in every production
        driver = GraphDatabase.driver(url, token, Config.build().withEncryptionLevel(Config.EncryptionLevel.NONE).toConfig());
        return driver;
    }

    @Neo4jDriver
    public void endSession(@Disposes Driver driver) {
        if (driver != null) {
            driver.close();
        }
    }
}
