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
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;


@Stateless
@Startup
public class Setup {

    Logger logger = Logger.getLogger(this.getClass().getName());
    private String url;
    private AuthToken token;
    private Driver driver;

    public Setup() throws IOException {
        logger.fine("starting up Neo4J");
        Properties properties = new Properties();
        try (InputStream stream = ClassLoader.getSystemResourceAsStream("settings.properties")) {
            properties.load(stream);
            stream.close();
        } catch (IOException ioex) {
            logger.severe("Error loading settings.properties");
            throw ioex;
        }
        url = properties.getProperty("neo4j.url");
        token = AuthTokens.basic(properties.getProperty("neo4j.username"), properties.getProperty("neo4j.password"));
    }

    @Produces
    @Neo4jDriver
    public Driver getDriver() {
        //TODO: Check if is correct obtain a new driver in every producer
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
